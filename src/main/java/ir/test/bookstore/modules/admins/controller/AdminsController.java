package ir.test.bookstore.modules.admins.controller;

import ir.test.bookstore.modules.admins.entity.Admins;
import ir.test.bookstore.modules.admins.service.AdminsService;
import ir.test.bookstore.modules.books.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@Controller
@RequestMapping("/admin/admins")
public class AdminsController {
    private AdminsService adminsService;
    private BooksService booksService;

    @Autowired
    public AdminsController(AdminsService adminsService, BooksService booksService){
        this.adminsService = adminsService;
        this.booksService = booksService;
    }

    @RequestMapping(value = {"/","", "/list" , "/list/" } , method = RequestMethod.GET)
    public String showAlladmins(Model model){
        model.addAttribute("admins" , this.adminsService.findAllAdmins());

        return "admin/admins/list";
    }

    @RequestMapping(value = {"/edit/{id}" } , method = RequestMethod.GET)
    public String editAdminForm(Model model , @PathVariable("id") long id){
        model.addAttribute("admin" , adminsService.findOne(id));
        return "admin/admins/register";
    }

    @RequestMapping(value = {"/register" , "/register/"} , method = RequestMethod.GET)
    public String registerForm(Model model){
        model.addAttribute("admin" , new Admins());
        return "admin/admins/register";
    }

    @RequestMapping(value = {"/register"} , method = RequestMethod.POST)
    public String registerAdmin(@ModelAttribute Admins admins) throws IOException, InvocationTargetException, IllegalAccessException {
        this.adminsService.save(admins);
        return "redirect:/admin/admins/list";
    }

    @RequestMapping(value = {"/rest"} , method = RequestMethod.GET)
    public @ResponseBody
    List<Admins> getAdmins(){
        return adminsService.findAllAdmins();
    }

    @RequestMapping( value =  {"/rest" } , method =  RequestMethod.POST)
    public @ResponseBody Admins saveAdmins(@RequestBody  Admins admins) throws IOException, InvocationTargetException, IllegalAccessException {
        return adminsService.save(admins);
    }
}
