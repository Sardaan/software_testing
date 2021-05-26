package lab2.logarithm;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Log5Test {
    private final double DELTA = 0.01;
    private static Ln lnMock;
    private static Log5 log5;

    @BeforeAll
    static void init(){
        lnMock = Mockito.spy(Ln.class);
        log5 = new Log5();
    }

    @Test
    public void nanTest() {
        Mockito.when(lnMock.of(Mockito.eq(Double.NaN))).thenReturn(Double.NaN);
        assertEquals(Double.NaN, log5.of(Double.NaN), DELTA);
    }

    @Test
    public void positiveInfinityTest() {
        Mockito.when(lnMock.of(Mockito.eq(Double.POSITIVE_INFINITY))).thenReturn(Double.NaN);
        assertEquals(0.0, log5.of(Double.POSITIVE_INFINITY), DELTA);
    }

    @Test
    public void negativeInfinityTest() {
        Mockito.when(lnMock.of(Mockito.eq(Double.NEGATIVE_INFINITY))).thenReturn(Double.NaN);
        assertEquals(Double.NaN, log5.of(Double.NEGATIVE_INFINITY), DELTA);
    }


    @Test
    public void testModuleLogarithmFifthBase() {

        Mockito.when(lnMock.of(Mockito.eq(1.0))).thenReturn(0.0);
        assertEquals(0, log5.of(1));

        Mockito.when(lnMock.of(Mockito.eq(0.0))).thenReturn(Double.NaN);
        assertEquals(Double.NaN, log5.of(0));

        Mockito.when(lnMock.of(Mockito.eq(-1.0))).thenReturn(Double.NaN);
        assertEquals(Double.NaN, log5.of(-1.0));

        Mockito.when(lnMock.of(Mockito.eq(0.33))).thenReturn(-1.108);
        assertEquals(-0.689, BigDecimal.valueOf(log5.of(0.33)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());

        Mockito.when(lnMock.of(Mockito.eq(7.0))).thenReturn(1.9459);
        assertEquals(1.209, BigDecimal.valueOf(log5.of(7.0)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());

    }

    @Test
    public void integrateTest(){
        assertEquals(-1.317, BigDecimal.valueOf(log5.of(0.12)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        assertEquals(-0.317, BigDecimal.valueOf(log5.of(0.6)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        assertEquals(-0.013, BigDecimal.valueOf(log5.of(0.98)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        assertEquals(0.33, BigDecimal.valueOf(log5.of(1.7)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        assertEquals(1.113, BigDecimal.valueOf(log5.of(6)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        assertEquals(1.544, BigDecimal.valueOf(log5.of(12)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());

    }

}
