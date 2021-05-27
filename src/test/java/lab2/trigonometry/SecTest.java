package lab2.trigonometry;
import lab2.Mocks;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SecTest {
    private final double DELTA = 0.01;
    private static Sec sec;

    @BeforeAll
    static void init(){
        sec = new Sec();
    }

    @Test
    public void nanTest() {
        sec.setCos(Mocks.getCosMock());
        assertEquals(Double.NaN, sec.of(Double.NaN), DELTA);
    }

    @Test
    public void positiveInfinityTest() {
        sec.setCos(Mocks.getCosMock());
        assertEquals(Double.NaN, sec.of(Double.POSITIVE_INFINITY), DELTA);
    }

    @Test
    public void negativeInfinityTest() {
        sec.setCos(Mocks.getCosMock());
        assertEquals(Double.NaN, sec.of(Double.NEGATIVE_INFINITY), DELTA);
    }


    @Test
    public void testSec() {

        sec.setCos(Mocks.getCosMock());
        assertEquals(9.940, BigDecimal.valueOf(sec.of(-1.47)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue(), DELTA);

        sec.setCos(Mocks.getCosMock());
        assertEquals(1.212, BigDecimal.valueOf(sec.of(-0.6)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue(), DELTA);

        sec.setCos(Mocks.getCosMock());
        assertEquals(1.609, BigDecimal.valueOf(sec.of(0.9)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue(), DELTA);

        sec.setCos(Mocks.getCosMock());
        assertEquals(-1.332, BigDecimal.valueOf(sec.of(2.42)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue(), DELTA);

        sec.setCos(Mocks.getCosMock());
        assertEquals(-1, sec.of(3.14), DELTA);

        sec.setCos(Mocks.getCosMock());
        assertEquals(-2.040, BigDecimal.valueOf(sec.of(4.2)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue(), DELTA);

        sec.setCos(Mocks.getCosMock());
        assertEquals(1.0, sec.of(0.0), DELTA);
    }


}
