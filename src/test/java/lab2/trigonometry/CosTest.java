package lab2.trigonometry;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CosTest {

    private final double DELTA = 0.01;
    private static Sin sin;
    private static Sin sinMock;
    private static Cos cos;

    @BeforeAll
    static void init(){
        sin = new Sin();
        sinMock = Mockito.spy(Sin.class);
        cos = new Cos();
    }

    @Test
    public void nanTest() {
        Mockito.when(sinMock.of(Mockito.eq(Double.NaN))).thenReturn(Double.NaN);
        assertEquals(Double.NaN, cos.of(Double.NaN), DELTA);
    }

    @Test
    public void positiveInfinityTest() {
        Mockito.when(sinMock.of(Mockito.eq(Double.POSITIVE_INFINITY))).thenReturn(Double.NaN);
        assertEquals(Double.NaN, cos.of(Double.POSITIVE_INFINITY), DELTA);
    }

    @Test
    public void negativeInfinityTest() {
        Mockito.when(sinMock.of(Mockito.eq(Double.POSITIVE_INFINITY))).thenReturn(Double.NaN);
        assertEquals(Double.NaN, cos.of(Double.NEGATIVE_INFINITY), DELTA);
    }

    @Test
    public void testCos() {

        Mockito.when(sinMock.of(Mockito.eq(0.0))).thenReturn(0.0);
        assertEquals(1, cos.of(0.0), DELTA);

        Mockito.when(sinMock.of(Mockito.eq(-3.14))).thenReturn(0.0);
        assertEquals(-1, cos.of(-3.14), DELTA);

        Mockito.when(sinMock.of(Mockito.eq(3.14))).thenReturn(0.0);
        assertEquals(-1, cos.of(3.14), DELTA);

        Mockito.when(sinMock.of(Mockito.eq(-0.8))).thenReturn(-0.717);
        assertEquals(0.697, BigDecimal.valueOf(cos.of(-0.8)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue(), DELTA);

        Mockito.when(sinMock.of(Mockito.eq(2.48))).thenReturn(0.614);
        assertEquals(-0.789, BigDecimal.valueOf(cos.of(2.48)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue(), DELTA);


    }

    @Test
    public void integrateTest(){
        assertEquals(1, cos.of(0.0));
        assertEquals(0.454, BigDecimal.valueOf(cos.of(-1.1)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        assertEquals(-0.819, BigDecimal.valueOf(cos.of(2.53)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        assertEquals(-0.539, BigDecimal.valueOf(cos.of(2.14)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        assertEquals(0.946, BigDecimal.valueOf(cos.of(-0.33)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());

    }
}
