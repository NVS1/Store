package ua.kiev.prog.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.kiev.prog.service.OrderService;
import ua.kiev.prog.service.ProductService;
import ua.kiev.prog.service.UserService;
import ua.kiev.prog.service.impl.OrderServiceImpl;
import ua.kiev.prog.service.impl.ProductServiceImpl;
import ua.kiev.prog.service.impl.UserServiceImpl;

@RestController
@RequestMapping("/admin")
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminController {
    private final UserService userService;
    private final ProductService productService;
    private final OrderService orderService;

    public AdminController(UserServiceImpl userService, ProductServiceImpl productService, OrderServiceImpl orderService) {
        this.userService = userService;
        this.productService = productService;
        this.orderService = orderService;
    }

}
