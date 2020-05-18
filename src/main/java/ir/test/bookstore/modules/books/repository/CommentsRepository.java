package ir.test.bookstore.modules.books.repository;

import ir.test.bookstore.modules.books.entity.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CommentsRepository extends JpaRepository<Comments,Long> {
    Optional<Comments> findBybooks_id(long id);
    List<Comments> findAllBybooks_id(long id);
}
