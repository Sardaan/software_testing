package lab2.logarithm;
import lab2.Mocks;
import lab2.trigonometry.Sin;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Log2Test {

    private final double DELTA = 0.01;
    private static Log2 log2;

    @BeforeAll
    static void init(){
        log2 = new Log2();
    }

    @Test
    public void nanTest() {
        log2.setLn(Mocks.getLnMock());
        assertEquals(Double.NaN, log2.of(Double.NaN), DELTA);
    }

    @Test
    public void positiveInfinityTest() {
        log2.setLn(Mocks.getLnMock());
        assertEquals(0.0, log2.of(Double.POSITIVE_INFINITY), DELTA);
    }

    @Test
    public void negativeInfinityTest() {
        log2.setLn(Mocks.getLnMock());
        assertEquals(Double.NaN, log2.of(Double.NEGATIVE_INFINITY), DELTA);
    }

        @Test
    public void testModuleLogarithmSecondBase() {

        log2.setLn(Mocks.getLnMock());
        assertEquals(Double.NaN, log2.of(0));

        log2.setLn(Mocks.getLnMock());
        assertEquals(Double.NaN, log2.of(-1.0));

        log2.setLn(Mocks.getLnMock());
        assertEquals(-1.184, BigDecimal.valueOf(log2.of(0.44)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue(), DELTA);

        log2.setLn(Mocks.getLnMock());
        assertEquals(-0.578, BigDecimal.valueOf(log2.of(0.67)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue(), DELTA);

        log2.setLn(Mocks.getLnMock());
        assertEquals(2.414, BigDecimal.valueOf(log2.of(5.33)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue(), DELTA);
    }

}
