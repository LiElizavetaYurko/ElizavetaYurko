package org.example;

interface GeometricShape {
    default double calculatePerimeter() {
        double[] dimensions = getDimensions();
        double perimeter = 0;
        for (double d : dimensions) {
            perimeter += d;
        }
        return perimeter;
    }
    default double[] getDimensions(){
        return new double[]{};
    }
    double calculateArea();
    String getFillColor();
    String getBorderColor();
    default void printInfo() {
        System.out.println("Фигура: " + this.getClass().getSimpleName());
        System.out.println("Периметр: " + String.format("%.2f", calculatePerimeter()));
        System.out.println("Площадь: " + String.format("%.2f", calculateArea()));
        System.out.println("Цвет заливки: " + getFillColor());
        System.out.println("Цвет границы: " + getBorderColor());
        System.out.println("----------------------");
    }
}