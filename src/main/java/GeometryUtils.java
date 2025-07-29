public class GeometryUtils {

    public static double triangleArea(double a, double b, double c) {
        // Проверка на положительность сторон
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException("Стороны должны быть положительными");
        }

        // Проверка условия существования треугольника
        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new IllegalArgumentException("Невалидный треугольник: сумма двух сторон меньше или равна третьей");
        }

        // Формула Герона
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }
}