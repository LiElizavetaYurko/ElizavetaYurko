package org.example;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        //1
        Product product = new Product("Samsung S25 Ultra", LocalDate.now(),
                "Samsung Corp.", "Korea", 5599.0, true);
        product.printInfo();

        //2
        Product[] productsArray = new Product[5];
        productsArray[0] = new Product("Samsung S25 Ultra", LocalDate.parse("2025-02-01"),
                "Samsung Corp.", "Korea", 5599.00, true);
        productsArray[1] = new Product("iPhone 16 Pro", LocalDate.parse("2024-09-15"),
                "Apple Inc.", "USA", 6499.00, false);
        productsArray[2] = new Product("Xiaomi 14", LocalDate.parse("2024-01-10"),
                "Xiaomi", "China", 3499.00, true);
        productsArray[3] = new Product("Google Pixel 8", LocalDate.parse("2023-10-04"),
                "Google", "USA", 4999.00, false);
        productsArray[4] = new Product("OnePlus 12", LocalDate.parse("2023-12-05"),
                "OnePlus", "China", 4299.00, true);

        //3
        Park park = new Park("park1");
        park.addAttraction("аттракцион1", "18:00 - 23:00", 25.5);
        park.addAttraction("аттракцион2", "19:00 - 22:00", 30.0);
        park.addAttraction("аттракцион3", "17:30 - 24:00", 24.9);
        park.printInfo();
    }
}
