import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class GeometryUtilsTest {

    @Test
    public void triangleArea_ValidSides_ReturnsCorrectArea() {
        assertEquals(GeometryUtils.triangleArea(3, 4, 5), 6.0);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void triangleArea_ZeroSide_ThrowsException() {
        GeometryUtils.triangleArea(0, 4, 5);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void triangleArea_NegativeSide_ThrowsException() {
        GeometryUtils.triangleArea(-1, 2, 2);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void triangleArea_InvalidTriangle_ThrowsException() {
        GeometryUtils.triangleArea(1, 2, 10); // 1+2 < 10
    }
}