package service;
import model.CartProduct;
import model.Product;
import java.util.List;

public class ShippingService {
    public static void ship(List<CartProduct> items) {
        System.out.println("** Shipment notice **");

        double totalWeight = 0;

        for (CartProduct item : items) {
            Product p = item.getProduct();
            if (p.isShipped()) {
                double itemWeight = p.getWeight(); // weight per piece
                int quantity = item.getQuantity();
                totalWeight += itemWeight * quantity;

                int grams = (int)(itemWeight * 1000); // for display
                System.out.println(quantity + "x " + p.getName() + " " + grams + "g");
            }
        }

        System.out.printf("Total package weight: %.1fkg%n", totalWeight);
    }
}
