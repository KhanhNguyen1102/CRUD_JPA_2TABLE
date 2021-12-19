package repository;

import model.Category;
import model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository // đánh dấu @Repository tự động tiêm interface này vào Spring Container quản lý
public interface IProductRepository extends JpaRepository<Product, Long> {
    // extends 1 interface nào đó của Spring Data JPA sẽ làm cho interface này
    // có đầy đủ các phương thức crud liên quan đến class Product
    // mọi người cần chuyền vào class và kiểu dữ liệu của khoá chính của class này
    Iterable<Product> findAllByCategory(Category category);
    // Spring Data JPA còn hỗ trợ thêm tự truy vấn đến cơ sở dữ liệu theo tên
    // như tên tương đương với câu truy vấn: select * from customer where categoryId = ?
    Iterable<Product> findAllByNameContaining(String name);
}