package ua.kiev.prog.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ua.kiev.prog.model.order.Order;
import ua.kiev.prog.model.order.Status;

import java.util.Date;

@Service
public interface OrderService {
    Order findOrderById (Long id);
    Page<Order> findAll (Pageable pageable);
    Page<Order> findOrderByStatus (Status status, Pageable pageable);
    Page<Order> findOrderByDateAfter (Date date, Pageable pageable);
    Page<Order> findOrderByDateBefore (Date date, Pageable pageable);
    void deleteOrder (Order order);
    void updateOrder (Order order);
 }
