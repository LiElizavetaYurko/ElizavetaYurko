import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ComparisonUtilsTest {

    @Test
    void compare_FirstGreater_ReturnsGreater() {
        assertEquals("5 > 3", ComparisonUtils.compare(5, 3));
    }

    @Test
    void compare_SecondGreater_ReturnsLess() {
        assertEquals("2 < 4", ComparisonUtils.compare(2, 4));
    }

    @Test
    void compare_EqualNumbers_ReturnsEqual() {
        assertEquals("7 == 7", ComparisonUtils.compare(7, 7));
    }

    @Test
    void compare_MaxIntAndMinInt_ReturnsGreater() {
        assertEquals("2147483647 > -2147483648",
                ComparisonUtils.compare(Integer.MAX_VALUE, Integer.MIN_VALUE));
    }
}