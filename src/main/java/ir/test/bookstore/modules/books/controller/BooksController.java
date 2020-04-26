package ir.test.bookstore.modules.books.controller;

import ir.test.bookstore.modules.books.entity.Books;
import ir.test.bookstore.modules.books.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
//@RequestMapping("/books")
public class BooksController {
    private BooksService booksService;

    @Autowired
    public BooksController(BooksService booksService){
        this.booksService = booksService;
    }

    @RequestMapping(value = {"/admin/books/register/" , "/admin/books/register"} , method = RequestMethod.GET)
    public String registerbookform(Model model){
        model.addAttribute("books" , new Books());
        return "admin/books/register";
    }

    @RequestMapping(value = {"/admin/books/register","/admin/books/register/"} , method = RequestMethod.POST)
    public String registerbook(@ModelAttribute Books books) throws IOException {
        this.booksService.saveBooks(books);
        return "admin/books/register";
    }

    @RequestMapping(value = "/admin/books/{id}" )
    public String findOneBookadmin(Model model , @PathVariable long id){
        model.addAttribute("books", this.booksService.findOne(id));
        return "admin/books/detail";
    }

    @RequestMapping(value = "/books/{id}" )
    public String findOneBook(Model model , @PathVariable long id){
        model.addAttribute("books", this.booksService.findOne(id));
        return "books/detail";
    }

    @RequestMapping(value = "/rest" , method = RequestMethod.GET)
    public @ResponseBody List<Books> getBooks(){
        return this.booksService.findAllBooks();
    }

    @RequestMapping(value = "/rest" , method = RequestMethod.POST)
    public @ResponseBody
    Books saveBooks(@RequestBody Books books) throws IOException {
        return this.booksService.saveBooks(books);
    }
}
