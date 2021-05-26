package lab2.logarithm;
import lab2.trigonometry.Sin;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Log2Test {

    private final double DELTA = 0.01;
    private static Ln lnMock;
    private static Log2 log2;

    @BeforeAll
    static void init(){
        lnMock = Mockito.spy(Ln.class);
        log2 = new Log2();
    }

    @Test
    public void nanTest() {
        Mockito.when(lnMock.of(Mockito.eq(Double.NaN))).thenReturn(Double.NaN);
        assertEquals(Double.NaN, log2.of(Double.NaN), DELTA);
    }

    @Test
    public void positiveInfinityTest() {
        Mockito.when(lnMock.of(Mockito.eq(Double.POSITIVE_INFINITY))).thenReturn(Double.NaN);
        assertEquals(0.0, log2.of(Double.POSITIVE_INFINITY), DELTA);
    }

    @Test
    public void negativeInfinityTest() {
        Mockito.when(lnMock.of(Mockito.eq(Double.NEGATIVE_INFINITY))).thenReturn(Double.NaN);
        assertEquals(Double.NaN, log2.of(Double.NEGATIVE_INFINITY), DELTA);
    }

    @Test
    public void testModuleLogarithmSecondBase() {
        //Проверка ln1=0
        Mockito.when(lnMock.of(Mockito.eq(1.0))).thenReturn(0.0);
        assertEquals(0, log2.of(1));
        //Проверка ln0=infinity
        Mockito.when(lnMock.of(Mockito.eq(0.0))).thenReturn(Double.NaN);
        assertEquals(Double.NaN, log2.of(0));

        Mockito.when(lnMock.of(Mockito.eq(-1.0))).thenReturn(Double.NaN);
        assertEquals(Double.NaN, log2.of(-1.0));

        Mockito.when(lnMock.of(Mockito.eq(0.44))).thenReturn(-0.821);
        assertEquals(-1.184, BigDecimal.valueOf(log2.of(0.44)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());

        Mockito.when(lnMock.of(Mockito.eq(0.67))).thenReturn(-0.4);
        assertEquals(-0.578, BigDecimal.valueOf(log2.of(0.67)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());

        Mockito.when(lnMock.of(Mockito.eq(5.33))).thenReturn(1.673);
        assertEquals(2.414, BigDecimal.valueOf(log2.of(5.33)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
    }

    @Test
    public void integrateTest(){
        assertEquals(-2.737, BigDecimal.valueOf(log2.of(0.15)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        assertEquals(-0.862, BigDecimal.valueOf(log2.of(0.55)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        assertEquals(-0.044, BigDecimal.valueOf(log2.of(0.97)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        assertEquals(0.705, BigDecimal.valueOf(log2.of(1.63)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        assertEquals(2, BigDecimal.valueOf(log2.of(4)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        assertEquals(3.134, BigDecimal.valueOf(log2.of(8.78)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());

    }
}
