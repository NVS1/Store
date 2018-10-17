package ua.kiev.prog.controller.admin;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ua.kiev.prog.model.order.Order;
import ua.kiev.prog.service.OrderService;

@RestController
@RequestMapping("/admin/order")
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminOrderController {
    private final OrderService orderService;

    public AdminOrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/")
    public Page<Order> orders (@PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable){
        return orderService.findAll(pageable);
    }

    @GetMapping("{id}")
    public Order order (@PathVariable("id") Order order){
        return order;
    }

    @PutMapping("{id}")
    public ResponseEntity<?> updateOrder (
            @PathVariable("id") Order orderDb,
            @RequestBody Order order){

        BeanUtils.copyProperties(order, orderDb,"id");
        orderService.updateOrder(orderDb);
        return new ResponseEntity<>(orderDb,HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteOrder (@PathVariable("id") Order order){
        orderService.deleteOrder(order);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
