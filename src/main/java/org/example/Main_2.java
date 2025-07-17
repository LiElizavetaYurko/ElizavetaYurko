package org.example;
import java.util.ArrayList;
import java.util.List;

public class Main_2 {
    public static void main(String[] args) {
        List<GeometricShape> shapes = new ArrayList<>();

        shapes.add(new Circle(10, "Белый", "Черный"));
        shapes.add(new Rectangle(5, 6, "Синий", "Белый"));
        shapes.add(new Triangle(3, 4, 5, "Зеленый", "Желтый"));

        for (GeometricShape shape : shapes) {
            shape.printInfo();
        }
    }
}

