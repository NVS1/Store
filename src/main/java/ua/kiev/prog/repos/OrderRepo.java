package ua.kiev.prog.repos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.kiev.prog.model.order.Order;
import ua.kiev.prog.model.order.Status;

import java.util.Date;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long> {
    Page<Order> findOrderByStatus(Status status, Pageable pageable);
    Page<Order> findOrderByDateAfter(Date date, Pageable pageable);
    Page<Order> findOrderByDateBefore (Date date, Pageable pageable);
}
