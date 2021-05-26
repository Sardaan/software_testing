package lab2.logarithm;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Log10Test {

    private final double DELTA = 0.01;
    private static Ln lnMock;
    private static Log10 log10;

    @BeforeAll
    static void init(){
        lnMock = Mockito.spy(Ln.class);
        log10 = new Log10();
    }

    @Test
    public void nanTest() {
        Mockito.when(lnMock.of(Mockito.eq(Double.NaN))).thenReturn(Double.NaN);
        assertEquals(Double.NaN, log10.of(Double.NaN), DELTA);
    }

    @Test
    public void positiveInfinityTest() {
        Mockito.when(lnMock.of(Mockito.eq(Double.POSITIVE_INFINITY))).thenReturn(Double.NaN);
        assertEquals(0.0, log10.of(Double.POSITIVE_INFINITY), DELTA);
    }

    @Test
    public void negativeInfinityTest() {
        Mockito.when(lnMock.of(Mockito.eq(Double.NEGATIVE_INFINITY))).thenReturn(Double.NaN);
        assertEquals(Double.NaN, log10.of(Double.NEGATIVE_INFINITY), DELTA);
    }

    @Test
    public void testModuleLogarithmTensBase() {

        Mockito.when(lnMock.of(Mockito.eq(1.0))).thenReturn(0.0);
        assertEquals(0, log10.of(1), DELTA);

        Mockito.when(lnMock.of(Mockito.eq(0.0))).thenReturn(Double.NaN);
        assertEquals(Double.NaN, log10.of(0), DELTA);

        Mockito.when(lnMock.of(Mockito.eq(-1.0))).thenReturn(Double.NaN);
        assertEquals(Double.NaN, log10.of(-1.0), DELTA);

        Mockito.when(lnMock.of(Mockito.eq(0.33))).thenReturn(-1.108);
        assertEquals(-0.481, BigDecimal.valueOf(log10.of(0.33)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue(), DELTA);

        Mockito.when(lnMock.of(Mockito.eq(7.0))).thenReturn(1.9459);
        assertEquals(0.845, BigDecimal.valueOf(log10.of(7.0)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue(), DELTA);

    }

    @Test
    public void integrateTest(){
        assertEquals(-0.824, BigDecimal.valueOf(log10.of(0.15)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        assertEquals(-0.260, BigDecimal.valueOf(log10.of(0.55)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        assertEquals(-0.013, BigDecimal.valueOf(log10.of(0.97)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        assertEquals(0.212, BigDecimal.valueOf(log10.of(1.63)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        assertEquals(0.826, BigDecimal.valueOf(log10.of(6.7)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        assertEquals(0.943, BigDecimal.valueOf(log10.of(8.78)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());

    }
}
