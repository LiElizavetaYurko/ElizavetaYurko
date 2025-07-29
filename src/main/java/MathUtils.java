public class MathUtils {

    // Вычисление факториала
    public static int factorial(int n) {
        if (n < 0) throw new IllegalArgumentException("Факториал отрицательного числа не определен");
        return (n == 0) ? 1 : n * factorial(n - 1);
    }

    // Арифметические операции
    public static int add(int a, int b) { return a + b; }
    public static int subtract(int a, int b) { return a - b; }
    public static int multiply(int a, int b) { return a * b; }
    public static double divide(int a, int b) {
        if (b == 0) throw new ArithmeticException("Деление на ноль");
        return (double) a / b;
    }
}