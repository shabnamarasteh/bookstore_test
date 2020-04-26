package ir.test.bookstore.modules.borrow.repository;

import ir.test.bookstore.modules.borrow.entity.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowRepository extends JpaRepository<Borrow,Long> {
}
