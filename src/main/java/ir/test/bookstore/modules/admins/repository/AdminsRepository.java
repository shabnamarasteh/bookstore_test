package ir.test.bookstore.modules.admins.repository;

import ir.test.bookstore.modules.admins.entity.Admins;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminsRepository extends JpaRepository<Admins,Long> {

}
