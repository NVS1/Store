package ua.kiev.prog.model.order;

import lombok.Data;
import lombok.NoArgsConstructor;
import ua.kiev.prog.model.ProductItem;
import ua.kiev.prog.model.user.Account;
import ua.kiev.prog.model.user.Address;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date = new Date();
    @Enumerated(EnumType.STRING)
    private Status status = Status.NEW;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account owner;
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ProductItem> productItemList = new ArrayList<>();
    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    public Long getPrice (){
        Long price = 0L;
        for (ProductItem productItem : productItemList) {
            price+=productItem.getPrice();
        }
        return price;
    }
}
