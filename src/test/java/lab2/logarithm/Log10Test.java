package lab2.logarithm;
import lab2.Mocks;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Log10Test {

    private final double DELTA = 0.01;
    private static Log10 log10;

    @BeforeAll
    static void init(){
        log10 = new Log10();
    }

    @Test
    public void nanTest() {
        log10.setLn(Mocks.getLnMock());
        assertEquals(Double.NaN, log10.of(Double.NaN), DELTA);
    }

    @Test
    public void positiveInfinityTest() {
        log10.setLn(Mocks.getLnMock());
        assertEquals(0.0, log10.of(Double.POSITIVE_INFINITY), DELTA);
    }

    @Test
    public void negativeInfinityTest() {
        log10.setLn(Mocks.getLnMock());
        assertEquals(Double.NaN, log10.of(Double.NEGATIVE_INFINITY), DELTA);
    }

    @Test
    public void testModuleLogarithmTensBase() {
        log10.setLn(Mocks.getLnMock());
        assertEquals(Double.NaN, log10.of(0.0), DELTA);

        log10.setLn(Mocks.getLnMock());
        assertEquals(Double.NaN, log10.of(-1.0), DELTA);

        log10.setLn(Mocks.getLnMock());
        assertEquals(-0.357, BigDecimal.valueOf(log10.of(0.44)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue(), DELTA);

        log10.setLn(Mocks.getLnMock());
        assertEquals(-0.174, BigDecimal.valueOf(log10.of(0.67)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue(), DELTA);

        log10.setLn(Mocks.getLnMock());
        assertEquals(0.727, BigDecimal.valueOf(log10.of(5.33)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue(), DELTA);

    }

}
