package ua.kiev.prog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ua.kiev.prog.model.order.Order;
import ua.kiev.prog.model.product.Product;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table (name = "product_items")
public class ProductItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;
    private Integer amount = 1;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private Order order;
    public Long getPrice(){
        return product.getPrice()*amount;
    }
    public void amountIncrement(){
        this.amount++;
    }
    public void amountDecrement(){
        this.amount--;
        if (this.amount<=0){
            this.amount=1;
        }
    }
    public void setAmount(Integer amount){
        if (amount<=0){
            this.amount = 1;
        } else{
            this.amount=amount;
        }
    }
}
