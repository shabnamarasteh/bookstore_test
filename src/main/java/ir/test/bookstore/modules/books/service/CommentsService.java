package ir.test.bookstore.modules.books.service;

import ir.test.bookstore.modules.books.entity.Comments;
import ir.test.bookstore.modules.books.repository.CommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentsService {
    private CommentsRepository commentsRepository;

    @Autowired
    public CommentsService(CommentsRepository commentsRepository){
        this.commentsRepository = commentsRepository;
    }

    public List<Comments> findByBooksId(long id) {
        return this.commentsRepository.findAllBybooks_id(id);
    }

    public Comments saveComments(Comments comments){
        return this.commentsRepository.save(comments);
    }

    public List<Comments> findAllComments(){
        return this.commentsRepository.findAll();
    }
}
