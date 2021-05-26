package lab2.trigonometry;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CotTest {

    private final double DELTA = 0.01;
    private static Sin sinMock;
    private static Cos cosMock;
    private static Cot cot;

    @BeforeAll
    static void init(){
        sinMock = Mockito.spy(Sin.class);
        cosMock = Mockito.spy(Cos.class);
        cot = new Cot();
    }

    @Test
    public void nanTest() {
        Mockito.when(sinMock.of(Mockito.eq(Double.NaN))).thenReturn(Double.NaN);
        Mockito.when(cosMock.of(Mockito.eq(Double.NaN))).thenReturn(Double.NaN);
        assertEquals(Double.NaN, cot.of(Double.NaN), DELTA);
    }

    @Test
    public void positiveInfinityTest() {
        Mockito.when(sinMock.of(Mockito.eq(Double.POSITIVE_INFINITY))).thenReturn(Double.NaN);
        Mockito.when(cosMock.of(Mockito.eq(Double.POSITIVE_INFINITY))).thenReturn(Double.NaN);
        assertEquals(Double.NaN, cot.of(Double.POSITIVE_INFINITY), DELTA);
    }

    @Test
    public void negativeInfinityTest() {
        Mockito.when(sinMock.of(Mockito.eq(Double.NEGATIVE_INFINITY))).thenReturn(Double.NaN);
        Mockito.when(cosMock.of(Mockito.eq(Double.NEGATIVE_INFINITY))).thenReturn(Double.NaN);
        assertEquals(Double.NaN, cot.of(Double.NEGATIVE_INFINITY), DELTA);
    }
    @Test
    public void testCot() {
        Mockito.when(cosMock.of(Mockito.eq(0.165))).thenReturn(0.98641);
        Mockito.when(sinMock.of(Mockito.eq(0.165))).thenReturn(0.16425);
        assertEquals(6.006, BigDecimal.valueOf(cot.of(0.165)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue(), DELTA);

        Mockito.when(cosMock.of(Mockito.eq(0.465))).thenReturn(0.893821);
        Mockito.when(sinMock.of(Mockito.eq(0.465))).thenReturn(0.448422);
        assertEquals(1.993, BigDecimal.valueOf(cot.of(0.465)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue(), DELTA);


        Mockito.when(cosMock.of(Mockito.eq(2.2))).thenReturn(-0.5885);
        Mockito.when(sinMock.of(Mockito.eq(2.2))).thenReturn(0.8084);
        assertEquals(-0.728, BigDecimal.valueOf(cot.of(2.2)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue(), DELTA);

        Mockito.when(cosMock.of(Mockito.eq(0.0))).thenReturn(0.0);
        Mockito.when(sinMock.of(Mockito.eq(0.0))).thenReturn(1.0);
        assertEquals(Double.POSITIVE_INFINITY, cot.of(0.0), DELTA);
    }

    @Test
    public void integrateTest(){
        assertEquals(5.9, BigDecimal.valueOf(cot.of(-2.974)).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue());
        assertEquals(0.858, BigDecimal.valueOf(cot.of(-2.28)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        assertEquals(0.422, BigDecimal.valueOf(cot.of(-1.97)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        assertEquals(-0.436, BigDecimal.valueOf(cot.of(-1.16)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        assertEquals(-4.601, BigDecimal.valueOf(cot.of(-0.214)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        assertEquals(-10.495, BigDecimal.valueOf(cot.of(-0.095)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());

    }

}
