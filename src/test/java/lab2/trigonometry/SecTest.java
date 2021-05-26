package lab2.trigonometry;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SecTest {
    private final double DELTA = 0.01;
    private static Cos cosMock;
    private static Sec sec;

    @BeforeAll
    static void init(){
        cosMock = Mockito.spy(Cos.class);
        sec = new Sec();
    }

    @Test
    public void nanTest() {
        Mockito.when(cosMock.of(Mockito.eq(Double.NaN))).thenReturn(Double.NaN);
        assertEquals(Double.NaN, sec.of(Double.NaN), DELTA);
    }

    @Test
    public void positiveInfinityTest() {
        Mockito.when(cosMock.of(Mockito.eq(Double.POSITIVE_INFINITY))).thenReturn(Double.NaN);
        assertEquals(Double.NaN, sec.of(Double.POSITIVE_INFINITY), DELTA);
    }

    @Test
    public void negativeInfinityTest() {
        Mockito.when(cosMock.of(Mockito.eq(Double.POSITIVE_INFINITY))).thenReturn(Double.NaN);
        assertEquals(Double.NaN, sec.of(Double.NEGATIVE_INFINITY), DELTA);
    }


    @Test
    public void testSec() {

        Mockito.when(cosMock.of(Mockito.eq(-1.47))).thenReturn(0.100626);
        assertEquals(9.854, BigDecimal.valueOf(sec.of(-1.47)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue(), DELTA);

        Mockito.when(cosMock.of(Mockito.eq(-0.6))).thenReturn(0.8253);
        assertEquals(1.212, BigDecimal.valueOf(sec.of(-0.6)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue(), DELTA);

        Mockito.when(cosMock.of(Mockito.eq(0.9))).thenReturn(0.6216);
        assertEquals(1.609, BigDecimal.valueOf(sec.of(0.9)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue(), DELTA);

        Mockito.when(cosMock.of(Mockito.eq(2.42))).thenReturn(-0.75075);
        assertEquals(-1.332, BigDecimal.valueOf(sec.of(2.42)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue(), DELTA);

        Mockito.when(cosMock.of(Mockito.eq(3.14))).thenReturn(-1.0);
        assertEquals(-1, sec.of(3.14), DELTA);

        Mockito.when(cosMock.of(Mockito.eq(4.2))).thenReturn(-0.4903);
        assertEquals(-2.040, BigDecimal.valueOf(sec.of(4.2)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue(), DELTA);

        Mockito.when(cosMock.of(Mockito.eq(1.57))).thenReturn(0.0);
        assertEquals(1.0, sec.of(0.0), DELTA);
    }

    @Test
    public void integrateTest(){
        assertEquals(-1.181, BigDecimal.valueOf(sec.of(2.58)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        assertEquals(-7.647, BigDecimal.valueOf(sec.of(1.702)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        assertEquals(6.469, BigDecimal.valueOf(sec.of(1.416)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        assertEquals(1.307, BigDecimal.valueOf(sec.of(0.7)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        assertEquals(1.286, BigDecimal.valueOf(sec.of(-0.68)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        assertEquals(10.355, BigDecimal.valueOf(sec.of(-1.475)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        assertEquals(-1.382, BigDecimal.valueOf(sec.of(-2.38)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());

    }

}
