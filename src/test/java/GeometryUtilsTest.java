import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GeometryUtilsTest {

    @Test
    void triangleArea_ValidSides_ReturnsCorrectArea() {
        assertEquals(6.0, GeometryUtils.triangleArea(3, 4, 5));
        assertEquals(14.697, GeometryUtils.triangleArea(5, 6, 7), 0.001);
    }

    @Test
    void triangleArea_ZeroSide_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () ->
                GeometryUtils.triangleArea(0, 4, 5)
        );
    }

    @Test
    void triangleArea_NegativeSide_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () ->
                GeometryUtils.triangleArea(-1, 2, 2)
        );
    }

    @Test
    void triangleArea_InvalidTriangle_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () ->
                GeometryUtils.triangleArea(1, 2, 10) // Невалидные стороны (1+2 < 10)
        );
    }
}