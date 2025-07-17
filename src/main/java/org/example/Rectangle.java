package org.example;
// Метод calculatePerimeter не переопределен,
// так как дефолтная реализация (сумма всех сторон) даст правильный результат.
public class Rectangle implements GeometricShape {
    private double width;
    private double height;
    private String fillColor;
    private String borderColor;

    public Rectangle(double width, double height, String fillColor, String borderColor) {
        this.width = width;
        this.height = height;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }
    @Override
    public double[] getDimensions() {
        return new double[]{ width, height, width, height };
    }
    @Override
    public double calculateArea() {
        return width * height;
    }
    @Override
    public String getFillColor() {
        return fillColor;
    }
    @Override
    public String getBorderColor() {
        return borderColor;
    }
}
