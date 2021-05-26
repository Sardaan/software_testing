package lab2.trigonometry;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TanTest {

    private final double DELTA = 0.01;
    private static Sin sinMock;
    private static Cos cosMock;
    private static Tan tan;

    @BeforeAll
    static void init(){
        sinMock = Mockito.spy(Sin.class);
        cosMock = Mockito.spy(Cos.class);
        tan = new Tan();
    }

    @Test
    public void nanTest() {
        Mockito.when(sinMock.of(Mockito.eq(Double.NaN))).thenReturn(Double.NaN);
        Mockito.when(cosMock.of(Mockito.eq(Double.NaN))).thenReturn(Double.NaN);
        assertEquals(Double.NaN, tan.of(Double.NaN), DELTA);
    }

    @Test
    public void positiveInfinityTest() {
        Mockito.when(sinMock.of(Mockito.eq(Double.POSITIVE_INFINITY))).thenReturn(Double.NaN);
        Mockito.when(cosMock.of(Mockito.eq(Double.POSITIVE_INFINITY))).thenReturn(Double.NaN);
        assertEquals(Double.NaN, tan.of(Double.POSITIVE_INFINITY), DELTA);
    }

    @Test
    public void negativeInfinityTest() {
        Mockito.when(sinMock.of(Mockito.eq(Double.NEGATIVE_INFINITY))).thenReturn(Double.NaN);
        Mockito.when(cosMock.of(Mockito.eq(Double.NEGATIVE_INFINITY))).thenReturn(Double.NaN);
        assertEquals(Double.NaN, tan.of(Double.NEGATIVE_INFINITY), DELTA);
    }

    @Test
    public void testTan() {

        Mockito.when(sinMock.of(Mockito.eq(Math.PI / 2))).thenReturn(1.0);
        Mockito.when(cosMock.of(Mockito.eq(Math.PI / 2))).thenReturn(0.0);
        assertEquals(Double.NaN, tan.of(Math.PI / 2));

        Mockito.when(sinMock.of(Mockito.eq(-3.0))).thenReturn(-0.141);
        Mockito.when(cosMock.of(Mockito.eq(-3.0))).thenReturn(-0.989);
        assertEquals(0.143, BigDecimal.valueOf(tan.of(-3.0)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());

    }

    @Test
    public void integrateTest(){
        assertEquals(0.121, BigDecimal.valueOf(tan.of(0.12)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        assertEquals(-1.424, BigDecimal.valueOf(tan.of(-4.1)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());

    }
}
