import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class MathUtilsTest {

    @Test
    public void testPerfectNumber() {
        assertEquals(1, MathUtils.checkOpNumber(6, "Perfect")); // 6 is a perfect number (1 + 2 + 3 = 6)
        assertEquals(0, MathUtils.checkOpNumber(10, "Perfect")); // 10 is not a perfect number (1 + 2 + 5 != 10)
    }

    @Test
    public void testSquareNumber() {
        assertEquals(1, MathUtils.checkOpNumber(9, "Square")); // 9 is a square number (3 * 3 = 9)
        assertEquals(0, MathUtils.checkOpNumber(8, "Square")); // 8 is not a square number
    }

    @Test
    public void testInvalidOperation() {
        assertEquals(-1, MathUtils.checkOpNumber(6, "Unknown")); // Invalid operation
    }
}
