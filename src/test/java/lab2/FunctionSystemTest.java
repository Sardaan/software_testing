package lab2;

import lab2.logarithm.*;
import lab2.trigonometry.*;
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
    public void FunctionTest() {
        function.setLog2(Mocks.getLog2Mock());
        function.setLog3(Mocks.getLog3Mock());
        function.setLog5(Mocks.getLog5Mock());
        function.setLog10(Mocks.getLog10Mock());
        assertEquals(-1.472, BigDecimal.valueOf(function.system(2.3)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue(), DELTA);

        function.setSin(Mocks.getSinMock());
        function.setCot(Mocks.getCotMock());
        function.setSec(Mocks.getSecMock());
        function.setTan(Mocks.getTanMock());
        assertEquals(0.244, BigDecimal.valueOf(function.system(-1.2)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue(), DELTA);


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
