package service.product;

import model.Category;
import model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import service.IGeneralService;

public interface IProductService extends IGeneralService<Product> {
    Iterable<Product> findAllByCategory(Category category);
    Iterable<Product> findAllByName(String name);
    Page<Product> findAll(Pageable pageable);
    Page<Product> findAllByNameContaining(String name, Pageable pageable);
}
