package ua.kiev.prog.model.product;

import lombok.Data;
import ua.kiev.prog.model.user.Account;

import javax.persistence.*;

@Data
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private Long price;
    @Enumerated(EnumType.STRING)
    private Category category;
    @OneToOne
    @JoinColumn(name = "photo_id")
    private Photo photo;
    @OneToOne
    @JoinColumn(name = "specification_id")
    private Specification specification;
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;
}
