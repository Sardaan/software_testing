package lab2.trigonometry;

import lab2.Mocks;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CosTest {

    private final double DELTA = 0.01;
    private static Cos cos;

    @BeforeAll
    static void init(){
        cos = new Cos();
    }

    @Test
    public void nanTest() {
        cos.setSin(Mocks.getSinMock());
        assertEquals(Double.NaN, cos.of(Double.NaN), DELTA);
    }

    @Test
    public void positiveInfinityTest() {
        cos.setSin(Mocks.getSinMock());
        assertEquals(Double.NaN, cos.of(Double.POSITIVE_INFINITY), DELTA);
    }

    @Test
    public void negativeInfinityTest() {
        cos.setSin(Mocks.getSinMock());
        assertEquals(Double.NaN, cos.of(Double.NEGATIVE_INFINITY), DELTA);
    }

    @Test
    public void testCos() {

        cos.setSin(Mocks.getSinMock());
        assertEquals(1, cos.of(0.0), DELTA);

        cos.setSin(Mocks.getSinMock());
        assertEquals(-1, cos.of(-3.14), DELTA);

        cos.setSin(Mocks.getSinMock());
        assertEquals(-1, cos.of(3.14), DELTA);

        cos.setSin(Mocks.getSinMock());
        assertEquals(0.697, BigDecimal.valueOf(cos.of(-0.8)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue(), DELTA);

        cos.setSin(Mocks.getSinMock());
        assertEquals(-0.789, BigDecimal.valueOf(cos.of(2.48)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue(), DELTA);

    }

}
