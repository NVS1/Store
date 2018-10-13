package ua.kiev.prog.repos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ua.kiev.prog.model.product.Category;
import ua.kiev.prog.model.product.Product;
import ua.kiev.prog.model.product.Specification;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
    Page<Product> findProductByNameContains (@Param("pattern") String name, Pageable pageable);
    Page<Product> findProductByCategory (Category category, Pageable pageable);
    Page<Product> findProductsBySpecification(Specification specification, Pageable pageable);
}
