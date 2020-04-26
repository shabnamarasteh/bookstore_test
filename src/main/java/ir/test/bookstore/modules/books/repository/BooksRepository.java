package ir.test.bookstore.modules.books.repository;

import ir.test.bookstore.modules.books.entity.Books;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BooksRepository extends JpaRepository<Books,Long> {

}
