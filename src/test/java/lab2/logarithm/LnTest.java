package lab2.logarithm;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LnTest {

    private final double DELTA = 0.01;
    private static Ln ln;

    @BeforeAll
    static void init(){
        ln = new Ln();
    }

    @Test
    public void nanTest() {
        assertEquals(Double.NaN, ln.of(Double.NaN), DELTA);
    }

    @Test
    public void positiveInfinityTest() {
        assertEquals(0.0, ln.of(Double.POSITIVE_INFINITY), DELTA);
    }

    @Test
    public void negativeInfinityTest() {
        assertEquals(Double.NaN, ln.of(Double.NEGATIVE_INFINITY), DELTA);
    }

    @Test
    public void naturalLogarithmTest() {
        assertEquals(0, ln.of(1.0), DELTA);
        assertEquals(Double.NaN, ln.of(0.0), DELTA);
        assertEquals(Double.NaN, ln.of(-1.0), DELTA);
        assertEquals( -0.223, BigDecimal.valueOf(ln.of(0.8)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue(), DELTA);
        assertEquals(-2.120, BigDecimal.valueOf(ln.of(0.12)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue(), DELTA);
        assertEquals(1.098, BigDecimal.valueOf(ln.of(3.0)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue(), DELTA);
        assertEquals(1.386, BigDecimal.valueOf(ln.of(4.0)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue(), DELTA);
    }
}
