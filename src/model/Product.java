package model;
import behavior.*;
public class Product {
    private String name;
    private double price;
    private int quantity;
    private ShippableInterface shippingBehavior;
    private ExpirableInterface expiryBehavior;

    public Product(String name, double price, int quantity, ShippableInterface shippingBehavior, ExpirableInterface expiryBehavior) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.shippingBehavior = shippingBehavior;
        this.expiryBehavior = expiryBehavior;
    }
    public String getName() {
        return name;
    }
    public int getQuantity() {
        return quantity;
    }
    public double getPrice() {
        return price;
    }

    public void reduceQuantity (int q){
        this.quantity -= q;
    }
    public boolean isExpired() {
        return expiryBehavior.isExpired();
    }
    public boolean isShipped() {
        return shippingBehavior.isEligibleForShipping();
    }
    public double getWeight(){
        return shippingBehavior.getWeight();
    }
}
