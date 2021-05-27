package lab2.trigonometry;
import lab2.Mocks;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TanTest {

    private final double DELTA = 0.01;
    private static Tan tan;

    @BeforeAll
    static void init(){
        tan = new Tan();
    }

    @Test
    public void nanTest() {
        tan.setSin(Mocks.getSinMock());
        tan.setCos(Mocks.getCosMock());
        assertEquals(Double.NaN, tan.of(Double.NaN), DELTA);
    }

    @Test
    public void positiveInfinityTest() {
        tan.setSin(Mocks.getSinMock());
        tan.setCos(Mocks.getCosMock());
        assertEquals(Double.NaN, tan.of(Double.POSITIVE_INFINITY), DELTA);
    }

    @Test
    public void negativeInfinityTest() {
        tan.setSin(Mocks.getSinMock());
        tan.setCos(Mocks.getCosMock());
        assertEquals(Double.NaN, tan.of(Double.NEGATIVE_INFINITY), DELTA);
    }

    @Test
    public void testTan() {

        tan.setSin(Mocks.getSinMock());
        tan.setCos(Mocks.getCosMock());
        assertEquals(Double.POSITIVE_INFINITY, tan.of(Math.PI / 2));

        tan.setSin(Mocks.getSinMock());
        tan.setCos(Mocks.getCosMock());
        assertEquals(0.143, BigDecimal.valueOf(tan.of(-3.0)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());

    }


}
