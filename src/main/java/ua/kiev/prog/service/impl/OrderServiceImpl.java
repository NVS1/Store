package ua.kiev.prog.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.kiev.prog.model.order.Order;
import ua.kiev.prog.model.order.Status;
import ua.kiev.prog.repos.OrderRepo;
import ua.kiev.prog.service.OrderService;

import java.util.Date;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepo orderRepo;

    public OrderServiceImpl(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    @Transactional
    @Override
    public Order findOrderById(Long id) {
        return orderRepo.getOne(id);
    }

    @Transactional
    @Override
    public Page<Order> findAll(Pageable pageable) {
        return orderRepo.findAll(pageable);
    }

    @Transactional
    @Override
    public Page<Order> findOrderByStatus(Status status, Pageable pageable) {
        return orderRepo.findOrderByStatus(status,pageable);
    }

    @Transactional
    @Override
    public Page<Order> findOrderByDateAfter(Date date, Pageable pageable) {
        return orderRepo.findOrderByDateAfter(date,pageable);
    }

    @Transactional
    @Override
    public Page<Order> findOrderByDateBefore(Date date, Pageable pageable) {
        return orderRepo.findOrderByDateBefore(date,pageable);
    }

    @Transactional
    @Override
    public void deleteOrder(Order order) {
        orderRepo.delete(order);
    }

    @Transactional
    @Override
    public void updateOrder(Order order) {
        orderRepo.save(order);
    }
}
