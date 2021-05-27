package lab2.logarithm;
import lab2.Mocks;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Log5Test {
    private final double DELTA = 0.01;
    private static Log5 log5;

    @BeforeAll
    static void init(){
        log5 = new Log5();
    }

    @Test
    public void nanTest() {
        log5.setLn(Mocks.getLnMock());
        assertEquals(Double.NaN, log5.of(Double.NaN), DELTA);
    }

    @Test
    public void positiveInfinityTest() {
        log5.setLn(Mocks.getLnMock());
        assertEquals(0.0, log5.of(Double.POSITIVE_INFINITY), DELTA);
    }

    @Test
    public void negativeInfinityTest() {
        log5.setLn(Mocks.getLnMock());
        assertEquals(Double.NaN, log5.of(Double.NEGATIVE_INFINITY), DELTA);
    }


    @Test
    public void testModuleLogarithmFifthBase() {

        log5.setLn(Mocks.getLnMock());
        assertEquals(Double.NaN, log5.of(0.0), DELTA);

        log5.setLn(Mocks.getLnMock());
        assertEquals(Double.NaN, log5.of(-1.0), DELTA);

        log5.setLn(Mocks.getLnMock());
        assertEquals(-0.51, BigDecimal.valueOf(log5.of(0.44)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue(), DELTA);

        log5.setLn(Mocks.getLnMock());
        assertEquals(-0.249, BigDecimal.valueOf(log5.of(0.67)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue(), DELTA);

        log5.setLn(Mocks.getLnMock());
        assertEquals(1.04, BigDecimal.valueOf(log5.of(5.33)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue(), DELTA);

    }


}
