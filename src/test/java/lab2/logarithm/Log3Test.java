package lab2.logarithm;
import lab2.Mocks;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Log3Test {
    private final double DELTA = 0.01;
    private static Log3 log3;

    @BeforeAll
    static void init(){
        log3 = new Log3();
    }

    @Test
    public void nanTest() {
        log3.setLn(Mocks.getLnMock());
        assertEquals(Double.NaN, log3.of(Double.NaN), DELTA);
    }

    @Test
    public void positiveInfinityTest() {
        log3.setLn(Mocks.getLnMock());
        assertEquals(0.0, log3.of(Double.POSITIVE_INFINITY), DELTA);
    }

    @Test
    public void negativeInfinityTest() {
        log3.setLn(Mocks.getLnMock());
        assertEquals(Double.NaN, log3.of(Double.NEGATIVE_INFINITY), DELTA);
    }


        @Test
    public void testModuleLogarithmThirdBase() {

        log3.setLn(Mocks.getLnMock());
        assertEquals(Double.NaN, log3.of(0.0), DELTA);

        log3.setLn(Mocks.getLnMock());
        assertEquals(Double.NaN, log3.of(-1.0), DELTA);

        log3.setLn(Mocks.getLnMock());
        assertEquals(-0.747, BigDecimal.valueOf(log3.of(0.44)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue(), DELTA);

        log3.setLn(Mocks.getLnMock());
        assertEquals(-0.364, BigDecimal.valueOf(log3.of(0.67)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue(), DELTA);

        log3.setLn(Mocks.getLnMock());
        assertEquals(1.522, BigDecimal.valueOf(log3.of(5.33)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue(), DELTA);


    }

}
