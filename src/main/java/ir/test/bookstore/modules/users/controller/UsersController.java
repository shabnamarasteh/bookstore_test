package ir.test.bookstore.modules.users.controller;

import ir.test.bookstore.modules.levels.service.LevelsService;
import ir.test.bookstore.modules.users.entity.Users;
import ir.test.bookstore.modules.users.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.lang.reflect.InvocationTargetException;

@Controller
public class UsersController {
    private UsersService usersService;
    private LevelsService levelsService;

    @Autowired
    public UsersController(UsersService usersService, LevelsService levelsService) {
        this.usersService = usersService;
        this.levelsService = levelsService;
    }

    @RequestMapping(value = {"/admin/users/register" , "/admin/users/register/"} , method = RequestMethod.GET)
    public String reisterUserForm(Model model){
        model.addAttribute("users" , new Users());
        model.addAttribute("levels" , this.levelsService.findAllLevels());
        return "admin/users/register";
    }

    @RequestMapping(value = {"/admin/users/register" , "/admin/users/register/"} , method = RequestMethod.POST)
    public String reisterUser(@ModelAttribute Users users) throws InvocationTargetException, IllegalAccessException {
        this.usersService.saveUsers(users);

        return "redirect:/admin/users/";
    }

    @RequestMapping(value = {"/admin/users/" , "/admin/users"} ,method = RequestMethod.GET)
    public String getAlluser(Model model){
        model.addAttribute("users",this.usersService.findAllUsers());
        return "admin/users/list";
    }

    @RequestMapping(value = {"/admin/users/edit/{id}/" , "/admin/users/edit/{id}"} ,method = RequestMethod.GET)
    public String getOneuser(Model model, @PathVariable("id") long id){
        model.addAttribute("users",this.usersService.findOneUser(id));
        model.addAttribute("levelslist" , this.levelsService.findAllLevels());
        return "admin/users/register";
    }


}
