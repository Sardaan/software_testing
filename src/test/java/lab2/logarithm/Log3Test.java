package lab2.logarithm;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Log3Test {
    private final double DELTA = 0.01;
    private static Ln lnMock;
    private static Log3 log3;

    @BeforeAll
    static void init(){
        lnMock = Mockito.spy(Ln.class);
        log3 = new Log3();
    }

    @Test
    public void nanTest() {
        Mockito.when(lnMock.of(Mockito.eq(Double.NaN))).thenReturn(Double.NaN);
        assertEquals(Double.NaN, log3.of(Double.NaN), DELTA);
    }

    @Test
    public void positiveInfinityTest() {
        Mockito.when(lnMock.of(Mockito.eq(Double.POSITIVE_INFINITY))).thenReturn(Double.NaN);
        assertEquals(0.0, log3.of(Double.POSITIVE_INFINITY), DELTA);
    }

    @Test
    public void negativeInfinityTest() {
        Mockito.when(lnMock.of(Mockito.eq(Double.NEGATIVE_INFINITY))).thenReturn(Double.NaN);
        assertEquals(Double.NaN, log3.of(Double.NEGATIVE_INFINITY), DELTA);
    }


    @Test
    public void testModuleLogarithmThirdBase() {

        Mockito.when(lnMock.of(Mockito.eq(1.0))).thenReturn(0.0);
        assertEquals(0, log3.of(1), DELTA);

        Mockito.when(lnMock.of(Mockito.eq(0.0))).thenReturn(Double.NaN);
        assertEquals(Double.NaN, lnMock.of(0), DELTA);

        Mockito.when(lnMock.of(Mockito.eq(-1.0))).thenReturn(Double.NaN);
        assertEquals(Double.NaN, lnMock.of(-1.0), DELTA);

        Mockito.when(lnMock.of(Mockito.eq(0.22))).thenReturn(-1.514);
        assertEquals(-1.514, BigDecimal.valueOf(lnMock.of(0.22)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue(), DELTA);

        Mockito.when(lnMock.of(Mockito.eq(0.99))).thenReturn(-0.01);
        assertEquals(-0.009, BigDecimal.valueOf(lnMock.of(0.99)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue(), DELTA);

        Mockito.when(lnMock.of(Mockito.eq(1.10))).thenReturn(0.0953);
        assertEquals(0.087, BigDecimal.valueOf(lnMock.of(1.10)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue(), DELTA);


    }

    @Test
    public void integrateTest(){
        assertEquals(-2.009, BigDecimal.valueOf(log3.of(0.11)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        assertEquals(-0.834, BigDecimal.valueOf(log3.of(0.4)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        assertEquals(-0.25, BigDecimal.valueOf(log3.of(0.76)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        assertEquals(1.262, BigDecimal.valueOf(log3.of(4)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        assertEquals(1.69, BigDecimal.valueOf(log3.of(6.4)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        assertEquals(1.904, BigDecimal.valueOf(log3.of(8.1)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());

    }
}
