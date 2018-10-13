package ua.kiev.prog.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.kiev.prog.model.ProductItem;

@Repository
public interface ProductItemRepo extends JpaRepository<ProductItem, Long> {
}
