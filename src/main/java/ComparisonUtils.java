public class ComparisonUtils {

    // Сравнение двух чисел
    public static String compare(int a, int b) {
        if (a > b) return a + " > " + b;
        else if (a < b) return a + " < " + b;
        else return a + " == " + b;
    }
}