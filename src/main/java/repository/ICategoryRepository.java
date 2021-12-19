package repository;

import model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ICategoryRepository extends JpaRepository<Category, Long> {
    Iterable<Category> findAllByName(String name);
    Iterable<Category> findAllByNameOrderByName(String name);

}
