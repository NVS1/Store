package ua.kiev.prog.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.kiev.prog.model.product.Photo;

@Repository
public interface PhotoRepo extends JpaRepository<Photo, Long> {
}
