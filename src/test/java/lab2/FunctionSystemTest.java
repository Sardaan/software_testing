package lab2;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class FunctionSystemTest {
    private final double DELTA = 0.001;
    private static FunctionSystem function;

    @BeforeAll
    static void init(){
        function = new FunctionSystem();
    }

    @Test
    public void integrateTest(){
        assertEquals(0.116, BigDecimal.valueOf(function.system(-5.233)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue(), DELTA);
        assertEquals(0.017, BigDecimal.valueOf(function.system(-2.263)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue(), DELTA);
        assertEquals(0.005, BigDecimal.valueOf(function.system(-1.503)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue(), DELTA);

        assertEquals(1.312, BigDecimal.valueOf(function.system(0.696)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue(), DELTA);
        assertEquals(-0.825, BigDecimal.valueOf(function.system(1.737)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue(), DELTA);
        assertEquals(-1.324, BigDecimal.valueOf(function.system(2.177)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue(), DELTA);

    }


}
