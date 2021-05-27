package lab2.trigonometry;

import lab2.Mocks;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CotTest {

    private final double DELTA = 0.01;
    private static Cot cot;

    @BeforeAll
    static void init(){
        cot = new Cot();
    }

    @Test
    public void nanTest() {
        cot.setTan(Mocks.getTanMock());
        assertEquals(Double.NaN, cot.of(Double.NaN), DELTA);
    }

    @Test
    public void positiveInfinityTest() {
        cot.setTan(Mocks.getTanMock());
        assertEquals(Double.NaN, cot.of(Double.POSITIVE_INFINITY), DELTA);
    }

    @Test
    public void negativeInfinityTest() {
        cot.setTan(Mocks.getTanMock());
        assertEquals(Double.NaN, cot.of(Double.NEGATIVE_INFINITY), DELTA);
    }
    @Test
    public void testCot() {
        cot.setTan(Mocks.getTanMock());
        assertEquals(5.998, BigDecimal.valueOf(cot.of(0.165)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue(), DELTA);

        cot.setTan(Mocks.getTanMock());
        assertEquals(2.02, BigDecimal.valueOf(cot.of(0.465)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue(), DELTA);

        cot.setTan(Mocks.getTanMock());
        assertEquals(-0.728, BigDecimal.valueOf(cot.of(2.2)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue(), DELTA);

        cot.setTan(Mocks.getTanMock());
        assertEquals(Double.POSITIVE_INFINITY, cot.of(0.0), DELTA);
    }


}
