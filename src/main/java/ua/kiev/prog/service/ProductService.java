package ua.kiev.prog.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ua.kiev.prog.model.product.Category;
import ua.kiev.prog.model.product.Photo;
import ua.kiev.prog.model.product.Product;
import ua.kiev.prog.model.product.Specification;

@Service
public interface ProductService {
    Product getProductById(Long id);
    Page<Product> findProductsByPattern (String pattern, Pageable pageable);
    Page<Product> findProductsByCategory(Category category, Pageable pageable);
    Page<Product> findProductsBySpecification(Specification specification, Pageable pageable);
    void addProduct (Product product);
    void deleteProduct(Product product);
    void updateProduct (Product product);
    Specification getSpecificationById (Long id);
    void updateSpecification (Specification specification);
    void addPhoto (Photo photo);
    void updatePhoto(Photo photo);
    void deletePhoto (Photo photo);
    Photo getPhotoById (Long id);
}
