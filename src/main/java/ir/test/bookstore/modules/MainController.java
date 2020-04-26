package ir.test.bookstore.modules;

import ir.test.bookstore.modules.admins.service.AdminsService;
import ir.test.bookstore.modules.books.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
    private BooksService booksService;
    private AdminsService adminsService;

    @Autowired
    public MainController(BooksService booksService, AdminsService adminsService)
    {
        this.booksService = booksService;
        this.adminsService = adminsService;
    }

    @RequestMapping(value = {"/" , ""})
    public String index(Model model){
        model.addAttribute("books", booksService.findAllBooks());
        return "index";
    }


    @RequestMapping(value = {"/admin/" , "/admin" } , method = RequestMethod.GET)
    public String adminindex(Model model){
        model.addAttribute("books", booksService.findAllBooks());
        model.addAttribute("admins" , this.adminsService.findAllAdmins());

        return "admin/index";
    }
}
