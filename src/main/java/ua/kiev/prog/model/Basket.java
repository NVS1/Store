package ua.kiev.prog.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Data
@Component
public class Basket {
    private Set<ProductItem> productItems = new HashSet<>();

    public Integer getAmount(){
        Integer count = 0;
        for (ProductItem productItem : productItems) {
            count+=productItem.getAmount();
        }
        return count;
    }
    public Long getPrice(){
        Long price = 0L;
        for (ProductItem productItem : productItems) {
            price+=productItem.getPrice();
        }
        return price;
    }
}
