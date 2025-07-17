package org.example;
// Метод calculatePerimeter не переопределен,
// так как дефолтная реализация (сумма всех сторон) даст правильный результат.
class Triangle implements GeometricShape {
    private double sideA;
    private double sideB;
    private double sideC;
    private String fillColor;
    private String borderColor;

    public Triangle(double sideA, double sideB, double sideC, String fillColor, String borderColor) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }
    @Override
    public double[] getDimensions() {
        return new double[]{ sideA, sideB, sideC };
    }
    @Override
    public double calculateArea() {
        double p = calculatePerimeter() / 2;
        return Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
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
