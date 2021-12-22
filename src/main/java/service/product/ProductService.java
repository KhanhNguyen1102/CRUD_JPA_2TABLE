package service.product;

import model.Category;
import model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import repository.IProductRepository;

import javax.transaction.Transactional;
import java.util.Optional;
@Transactional
@Service // đánh dấu @Service tự động tiêm interface này vào Spring Container quản lý
public class ProductService implements IProductService {
    @Autowired
    // gọi repository tương ứng ra từ Spring Container, các phương thức được repo cung cấp sẵn

    private IProductRepository productRepository;

    @Override
    public Iterable<Product> findAll() {

        return productRepository.findAll();
    } // iterable là lớp cha của các collection trong java


    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }
    //optional là kiểu dữ liệu đặc biệt, có thể kiểm tra dữ liệu là null hay không

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }
    // phương thức save này sẽ kiểm tra xem đối tượng truyền vào có id tồn tại chưa,
    // rồi thì cập nhật
    // chưa thì thêm mới

    @Override
    public void remove(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Iterable<Product> findAllByCategory(Category category) {
        return productRepository.findAllByCategory(category);
    }
    @Override
    public Iterable<Product> findAllByName(String name) {
        return productRepository.findAllByNameContaining(name);
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }
    @Override
    public Page<Product> findAllByNameContaining(String name, Pageable pageable) {
        return productRepository.findAllByNameContaining(name, pageable);
    }

}
