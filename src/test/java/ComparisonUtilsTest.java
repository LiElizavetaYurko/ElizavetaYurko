import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class ComparisonUtilsTest {

    @Test
    public void compare_FirstGreater_ReturnsGreater() {
        assertEquals(ComparisonUtils.compare(5, 3), "5 > 3");
    }

    @Test
    public void compare_SecondGreater_ReturnsLess() {
        assertEquals(ComparisonUtils.compare(2, 4), "2 < 4");
    }

    @Test
    public void compare_EqualNumbers_ReturnsEqual() {
        assertEquals(ComparisonUtils.compare(7, 7), "7 == 7");
    }

    @Test
    public void compare_MaxIntAndMinInt_ReturnsGreater() {
        assertEquals(ComparisonUtils.compare(Integer.MAX_VALUE, Integer.MIN_VALUE),
                "2147483647 > -2147483648");
    }

}