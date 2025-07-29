import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class MathUtilsTest {

    @Test
    public void factorial_PositiveNumber_ReturnsCorrectValue() {
        assertEquals(MathUtils.factorial(5), 120);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void factorial_NegativeNumber_ThrowsException() {
        MathUtils.factorial(-1);
    }

    @Test
    public void add_PositiveNumbers_ReturnsSum() {
        assertEquals(MathUtils.add(2, 3), 5);
    }

    @Test
    public void add_NegativeNumbers_ReturnsSum() {
        assertEquals(MathUtils.add(2, -3), -1);
    }

    @Test
    public void subtract_PositiveNumbers_ReturnsDifference() {
        assertEquals(MathUtils.subtract(5, 3), 2);
    }

    @Test
    public void subtract_NegativeResult_ReturnsNegative() {
        assertEquals(MathUtils.subtract(2, 7), -5);
    }

    @Test
    public void multiply_PositiveNumbers_ReturnsProduct() {
        assertEquals(MathUtils.multiply(2, 3), 6);
    }

    @Test
    public void multiply_ByZero_ReturnsZero() {
        assertEquals(MathUtils.multiply(5, 0), 0);
    }

    @Test
    public void divide_PositiveNumbers_ReturnsQuotient() {
        assertEquals(MathUtils.divide(10, 2), 5.0);
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void divide_ByZero_ThrowsException() {
        MathUtils.divide(1, 0);
    }
}