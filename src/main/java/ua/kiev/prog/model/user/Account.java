package ua.kiev.prog.model.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import ua.kiev.prog.model.order.Order;
import ua.kiev.prog.model.product.Product;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "accounts")
@AllArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String login;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role = Role.USER;
    private String name;
    private String phone;
    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Address> addresses = new ArrayList<>();
    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Order> orders = new ArrayList<>();
    @OneToMany(mappedBy = "account",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<Product> favorites = new HashSet<>();

    public Account() {
        this.email = login;
    }
}
