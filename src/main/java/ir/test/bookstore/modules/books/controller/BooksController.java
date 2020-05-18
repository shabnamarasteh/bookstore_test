package ir.test.bookstore.modules.books.controller;

import ir.test.bookstore.modules.books.entity.Books;
import ir.test.bookstore.modules.books.entity.Comments;
import ir.test.bookstore.modules.books.service.BooksService;
import ir.test.bookstore.modules.books.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Optional;

//@RequestMapping("/books")
@Controller
public class BooksController {
    private BooksService booksService;
    private CommentsService commentsService;

    @Autowired
    public BooksController(BooksService booksService,CommentsService commentsService){
        this.commentsService = commentsService;
        this.booksService = booksService;
    }

    /*-------------------
    -----START--ADMIN----
    ----------------------*/
    @RequestMapping(value = {"/admin/books/register/" , "/admin/books/register"} , method = RequestMethod.GET)
    public String registerbookform(Model model){
        model.addAttribute("books" , new Books());
        return "admin/books/register";
    }

    @RequestMapping(value = {"/admin/books/register","/admin/books/register/"} , method = RequestMethod.POST)
    public String registerbook(@ModelAttribute Books books) {
        try {
            System.out.println(books.getId());
            this.booksService.saveBooks(books);
        } catch (IOException e) {
            System.out.println("----------------1---------------");
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            System.out.println("----------------2---------------");
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            System.out.println("----------------3---------------");
            e.printStackTrace();
        }catch (Exception e){
            System.out.println("----------------4--------------");
            e.printStackTrace();
        }
        return "redirect:/admin/books/";
    }

    @RequestMapping(value = {"/admin/books/edit/{id}", "/admin/books/edit/{id}/"})
    public String showEditBooks(Model model, @PathVariable("id") long id){
        model.addAttribute("books", booksService.findOne(id));
        return "admin/books/register";
    }

    @RequestMapping(value = {"/admin/books/", "/admin/books" }, method = RequestMethod.GET)
    public String findAllBookadmin(Model model){
        model.addAttribute("books", this.booksService.findAllBooks());
        return "admin/books/list";
    }

    @RequestMapping(value = {"/admin/books/{id}" , "/admin.books/{id}/"}, method = RequestMethod.GET)
    public String findOneBookadmin(Model model , @PathVariable long id){
        model.addAttribute("book", this.booksService.findOne(id));
        model.addAttribute("comment" , new Comments());

        return "admin/books/detail";
    }

    /*-------------------
    -----END--ADMIN----
    ----------------------*/

    /*-------------------
    -----START--Client----
    ----------------------*/

    @RequestMapping(value = "/books/{id}" , method = RequestMethod.GET)
    public String findOneBook(Model model , @PathVariable long id){
        model.addAttribute("book", this.booksService.findOne(id));
        model.addAttribute("comments", this.commentsService.findByBooksId(id));
        return "books/detail";
    }

    @RequestMapping(value = {"/books/" , "/books"} , method = RequestMethod.GET)
    public String findAllBook(Model model){
        model.addAttribute("books", this.booksService.findAllBooks());
        return "books/list";
    }


    @RequestMapping(value = {"/admin/book/comments/{id}"} , method = RequestMethod.GET)
    public String showBooksCommentAdminByBookid(Model model , @PathVariable("id") long id){
        model.addAttribute("comments" , this.commentsService.findByBooksId(id));
        model.addAttribute("book", this.booksService.findOne(id));
        return "admin/books/comment";
    }


    /*-------------------
    -----END--Client----
    ----------------------*/

    /*-------------------
    -----START--REST----
    ----------------------*/
    @RequestMapping(value = "/rest" , method = RequestMethod.GET)
    public @ResponseBody List<Books> getBooks(){
        return this.booksService.findAllBooks();
    }

    @RequestMapping(value = "/rest" , method = RequestMethod.POST)
    public @ResponseBody
    Books saveBooks(@RequestBody Books books) throws IOException, InvocationTargetException, IllegalAccessException {
        return this.booksService.saveBooks(books);
    }
}
