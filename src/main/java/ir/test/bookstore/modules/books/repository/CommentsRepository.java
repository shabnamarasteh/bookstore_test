package ir.test.bookstore.modules.books.repository;

import ir.test.bookstore.modules.books.entity.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentsRepository extends JpaRepository<Comments,Long> {
}
