package ir.test.bookstore.modules.books.controller;

import ir.test.bookstore.modules.books.entity.Comments;
import ir.test.bookstore.modules.books.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Comments")
public class CommentsController {
    private CommentsService commentsService;

    @Autowired
    public CommentsController(CommentsService commentsService){
        this.commentsService = commentsService;
    }

    @RequestMapping(value = {"/",""} , method = RequestMethod.GET)
    public List<Comments> getComments(){
        return this.commentsService.findAllComments();
    }

    @RequestMapping(value = {"/" , ""} , method = RequestMethod.POST)
    public Comments saveComments(Comments comments){
        return this.commentsService.saveComments(comments);
    }

}
