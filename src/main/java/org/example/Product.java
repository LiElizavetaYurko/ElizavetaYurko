package org.example;

import java.time.LocalDate;
import java.util.Date;

public class Product {
    private String productName;
    private LocalDate productionDate;
    private String producer;
    private String country;
    private Double price;
    private Boolean isBooked;
    public Product(String productName,
                   LocalDate productionDate,
                   String producer,
                   String country,
                   Double price,
                   Boolean isBooked) {
        this.productName = productName;
        this.productionDate = productionDate;
        this.producer = producer;
        this.country = country;
        this.price = price;
        this.isBooked = isBooked;
    }
    public void printInfo(){
        System.out.println("Название товара: " + this.productName);
        System.out.println("Дата производства: " + this.productionDate);
        System.out.println("Производитель: " + this.producer);
        System.out.println("Страна происхождения: " + this.country);
        System.out.println("Цена: " + this.price);
        System.out.println("Забронирован: " + this.isBooked);
    }
}
