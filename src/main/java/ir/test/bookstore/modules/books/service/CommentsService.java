package ir.test.bookstore.modules.books.service;

import ir.test.bookstore.modules.books.entity.Comments;
import ir.test.bookstore.modules.books.repository.CommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentsService {
    private CommentsRepository commentsRepository;

    @Autowired
    public CommentsService(CommentsRepository commentsRepository){
        this.commentsRepository = commentsRepository;
    }

    public Comments saveComments(Comments comments){
        return this.commentsRepository.save(comments);
    }

    public List<Comments> findAllComments(){
        return this.commentsRepository.findAll();
    }
}
