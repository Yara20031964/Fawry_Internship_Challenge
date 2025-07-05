package model;
import service.ShippingService;
import java.util.List;


public class Customer {
    private String name;
    private double balance;
    private Cart cart;

    public Customer(String name, double balance) {
        this.name = name;
        this.balance = balance;
        this.cart = new Cart();
    }
    public Cart getCart() {
        return cart;
    }
    public void editBalance(double amount) {
        this.balance -= amount;
    }
    public void checkout() throws Exception{
        if(cart.isEmpty()) throw new Exception("Cart is empty");
        for(CartProduct product : cart.getItems()){
            if(product.getProduct().isExpired()){
                throw new Exception(product.getProduct().getName() + " is expired");
            }
            }
        double subtotal = cart.getSubtotal();
        double shippingFee = cart.getShippableProducts().stream().mapToDouble(item -> item.getProduct().getWeight() * item.getQuantity()).sum() * 5; // assuming shipping fee is 5 per unit of weight
        double total = subtotal + shippingFee;
        if(balance < total) throw new Exception("Insufficient balance");
        
        List<CartProduct> toShip = cart.getShippableProducts();
        if (!toShip.isEmpty()) {
        ShippingService.ship(toShip);
        System.out.println(" ");
        }
        editBalance(total);
        System.out.println("** Checkout receipt **");
        for (CartProduct item : cart.getItems()) {
            String name = item.getProduct().getName();
            int quantity = item.getQuantity();
            System.out.println(quantity + "x " + name + " " + (int) item.getTotalPrice());
        }
        System.out.println("----------------------");
        System.out.println("Subtotal " + (int)subtotal);
        System.out.println("Shipping " + (int)shippingFee);
        System.out.println("Amount " + (int)total);
        cart.clear();
    }
}
