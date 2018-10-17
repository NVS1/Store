package ua.kiev.prog.model;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Data
@Component
@Scope(value="session", proxyMode=ScopedProxyMode.TARGET_CLASS)
public class Cart {
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
    public void addProductItem (ProductItem productItem){
        productItems.add(productItem);
    }
    public void removeItem (ProductItem productItem){
        productItems.remove(productItem);
    }
    public void clearCart (){
        productItems.clear();
    }
}
