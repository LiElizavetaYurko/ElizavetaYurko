package org.example;

import java.util.ArrayList;
import java.util.List;

public class Park {
    private String parkName;
    private ArrayList<Attraction> attractions;
    public Park(String parkName){
        this.parkName = parkName;
        this.attractions = new ArrayList<Attraction>();
    }
    public void printInfo(){
        System.out.println(String.format("Парк: %s", parkName));
        for (Attraction attraction: this.attractions) {
            System.out.println(
                String.format(
                    "Аттракцион: %s | Время работы: %s | Цена: %.2f руб.",
                    attraction.name, attraction.workingHours, attraction.prise
                )
            );
        }
    }
    public class Attraction {
        private String name;
        private String workingHours;
        private Double prise;
        public Attraction(String name, String workingHours, Double price) {
            this.name = name;
            this.workingHours = workingHours;
            this.prise = price;
        }


    }
    public void addAttraction(String name, String workingHours, Double price) {
        this.attractions.add(new Attraction(name, workingHours, price));
    }
}
