package model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartProduct>items = new ArrayList<>();

    public void addItem(Product product, int quantity) throws Exception {
        if(quantity > product.getQuantity()){
            throw new Exception( product.getName() +  " is out of stock");
        }
        items.add(new CartProduct(product, quantity));

    }
    public boolean isEmpty(){
        return items.isEmpty();
    }
    public List<CartProduct> getItems() {
        return items;
    }
    public double getSubtotal(){
        return items.stream().mapToDouble(CartProduct::getTotalPrice).sum();
    } 
    public List<CartProduct> getShippableProducts(){
        List <CartProduct> result = new ArrayList<>();
        for (CartProduct item : items) {
            if(item.getProduct().isShipped()){
                result.add(item);
            }
            }
            return result;

    }
    public void clear() {
    items.clear();
}


}
