import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MathUtilsTest {

    @Test
    void factorial_PositiveNumber_ReturnsCorrectValue() {
        assertEquals(120, MathUtils.factorial(5));
    }

    @Test
    void factorial_Zero_ReturnsOne() {
        assertEquals(1, MathUtils.factorial(0));
    }

    @Test
    void factorial_NegativeNumber_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> MathUtils.factorial(-1));
    }

    @Test
    void add_PositiveNumbers_ReturnsSum() {
        assertEquals(5, MathUtils.add(2, 3));
    }

    @Test
    void add_NegativeNumbers_ReturnsSum() {
        assertEquals(-1, MathUtils.add(2, -3));
    }

    @Test
    void subtract_PositiveNumbers_ReturnsDifference() {
        assertEquals(2, MathUtils.subtract(5, 3));
    }

    @Test
    void subtract_NegativeResult_ReturnsNegative() {
        assertEquals(-5, MathUtils.subtract(2, 7));
    }

    @Test
    void multiply_PositiveNumbers_ReturnsProduct() {
        assertEquals(6, MathUtils.multiply(2, 3));
    }

    @Test
    void multiply_ByZero_ReturnsZero() {
        assertEquals(0, MathUtils.multiply(5, 0));
    }

    @Test
    void multiply_NegativeNumbers_ReturnsPositive() {
        assertEquals(6, MathUtils.multiply(-2, -3));
    }

    @Test
    void multiply_MaxIntByOne_ReturnsMaxInt() {
        assertEquals(Integer.MAX_VALUE, MathUtils.multiply(Integer.MAX_VALUE, 1));
    }

    @Test
    void divide_PositiveNumbers_ReturnsQuotient() {
        assertEquals(2.5, MathUtils.divide(5, 2));
    }

    @Test
    void divide_ByZero_ThrowsException() {
        assertThrows(ArithmeticException.class, () -> MathUtils.divide(1, 0));
    }

    @Test
    void divide_Rounding_ReturnsRoundedValue() {
        assertEquals(0.333, MathUtils.divide(1, 3), 0.001);
    }
}