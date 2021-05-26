package lab2.trigonometry;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SinTest {
    private final double DELTA = 0.01;
    private static Sin sin;


    @BeforeAll
    static void init(){
        sin = new Sin();
    }

    @Test
    public void nanTest() {
        assertEquals(Double.NaN, sin.of(Double.NaN), DELTA);
    }

    @Test
    public void positiveInfinityTest() {
        assertEquals(Double.NaN, sin.of(Double.POSITIVE_INFINITY), DELTA);
    }

    @Test
    public void negativeInfinityTest() {
        assertEquals(Double.NaN, sin.of(Double.NEGATIVE_INFINITY), DELTA);
    }

    @Test
    public void testSin() {
//        assertEquals(Double.NaN, function.sin(Double.NaN));
//        assertEquals(Double.NaN, function.sin(Double.NEGATIVE_INFINITY));

        assertEquals(0, BigDecimal.valueOf(sin.of(0.0)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        assertEquals(-0.262, BigDecimal.valueOf(sin.of(50.0)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        assertEquals(0.774, BigDecimal.valueOf(sin.of(70.0)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        assertEquals(0.841, BigDecimal.valueOf(sin.of(1.0)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        assertEquals(0.959, BigDecimal.valueOf(sin.of(-5.0)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());

    }

}
