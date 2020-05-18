package ir.test.bookstore.modules.books.controller;

import ir.test.bookstore.modules.books.entity.Comments;
import ir.test.bookstore.modules.books.service.BooksService;
import ir.test.bookstore.modules.books.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
//@RequestMapping("/Comments")
public class CommentsController {
    private CommentsService commentsService;
    private BooksService booksService;

    @Autowired
    public CommentsController(CommentsService commentsService){
        this.commentsService = commentsService;
    }

    @RequestMapping(value = {"/admin/comments/register" , "/admin/comments/register/"} , method = RequestMethod.POST)
    public String registerComment(@ModelAttribute Comments comments){
        this.commentsService.saveComments(comments);
        return "redirect:/admin/books/"+comments.getBookid();
    }

    @RequestMapping(value = {"/rest/comments/",""} , method = RequestMethod.GET)
    public List<Comments> getComments(){
        return this.commentsService.findAllComments();
    }

    @RequestMapping(value = {"/rest/comments/" , ""} , method = RequestMethod.POST)
    public Comments saveComments(Comments comments){
        return this.commentsService.saveComments(comments);
    }

}
