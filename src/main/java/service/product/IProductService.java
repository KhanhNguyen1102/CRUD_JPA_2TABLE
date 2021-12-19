package service.product;

import model.Category;
import model.Product;
import service.IGeneralService;

public interface IProductService extends IGeneralService<Product> {
    Iterable<Product> findAllByCategory(Category category);
    Iterable<Product> findAllByName(String name);
}
