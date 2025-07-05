// Main.java
import model.*;
import behavior.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        try {
            Customer yara = new Customer("Yara", 1000);

            Product cheese = new Product("Cheese", 50, 5,
                    new Shippable(1.5), new Expirable(LocalDate.of(2025, 7, 10)));

            Product tv = new Product("TV", 300, 2,
                    new Shippable(10.0), new NonExpirable());

            Product card = new Product("Scratch Card", 20, 10,
                    new NotShippable(), new NonExpirable());

            yara.getCart().addItem(cheese, 2);
            yara.getCart().addItem(tv, 1);
            yara.getCart().addItem(card, 1);

            yara.checkout();

        } catch (Exception e) {
            System.err.println("❌ ERROR: " + e.getMessage());
        }
    }
}
