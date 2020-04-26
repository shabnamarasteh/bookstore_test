package ir.test.bookstore.modules.levels.repository;

import ir.test.bookstore.modules.levels.entity.Levels;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LevelsRepository extends JpaRepository<Levels,Long> {
}
