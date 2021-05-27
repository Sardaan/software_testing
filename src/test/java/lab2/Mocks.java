package lab2;

import lab2.trigonometry.*;
import lab2.logarithm.*;
import org.mockito.AdditionalMatchers;
import org.mockito.Mockito;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Mocks {
    public static Cos getCosMock() {
        Cos cos = Mockito.mock(Cos.class);

        Mockito.when(cos.of(AdditionalMatchers.eq(0.0, 0.1))).thenReturn(1.0);
        Mockito.when(cos.of(AdditionalMatchers.eq(1.57, 0.1))).thenReturn(0.0);
        Mockito.when(cos.of(AdditionalMatchers.eq(-3, 0.1))).thenReturn(-0.989);
        Mockito.when(cos.of(AdditionalMatchers.eq(-1.47, 0.1))).thenReturn(0.1006);
        Mockito.when(cos.of(AdditionalMatchers.eq(-0.6, 0.1))).thenReturn(0.825);
        Mockito.when(cos.of(AdditionalMatchers.eq(0.9, 0.1))).thenReturn(0.6216);
        Mockito.when(cos.of(AdditionalMatchers.eq(2.42, 0.1))).thenReturn(-0.751);
        Mockito.when(cos.of(AdditionalMatchers.eq(3.14, 0.1))).thenReturn(-1.0);
        Mockito.when(cos.of(AdditionalMatchers.eq(4.2, 0.1))).thenReturn(-0.490);
        Mockito.when(cos.of(AdditionalMatchers.eq(1.57, 0.1))).thenReturn(0.0);

        Mockito.when(cos.of(Double.POSITIVE_INFINITY)).thenReturn(Double.NaN);
        Mockito.when(cos.of(Double.NEGATIVE_INFINITY)).thenReturn(Double.NaN);
        Mockito.when(cos.of(Double.NaN)).thenReturn(Double.NaN);

        return cos;
    }

    public static Cot getCotMock() {
        Cot cot = Mockito.mock(Cot.class);

        Mockito.when(cot.of(AdditionalMatchers.eq(-1.2, 0.1))).thenReturn(-0.389);

        return cot;
    }
    public static Sec getSecMock() {
        Sec sec = Mockito.mock(Sec.class);

        Mockito.when(sec.of(AdditionalMatchers.eq(-1.2, 0.1))).thenReturn(2.760);

        return sec;
    }

    public static Sin getSinMock() {
        Sin sin = Mockito.mock(Sin.class);

        Mockito.when(sin.of(AdditionalMatchers.eq(-1.2, 0.1))).thenReturn(-0.932);
        Mockito.when(sin.of(AdditionalMatchers.eq(Math.PI/2, 0.1))).thenReturn(1.0);
        Mockito.when(sin.of(AdditionalMatchers.eq(-3, 0.1))).thenReturn(-0.141);
        Mockito.when(sin.of(AdditionalMatchers.eq(0.0, 0.1))).thenReturn(0.0);
        Mockito.when(sin.of(AdditionalMatchers.eq(-3.14, 0.1))).thenReturn(0.0);
        Mockito.when(sin.of(AdditionalMatchers.eq(3.14, 0.1))).thenReturn(0.0);
        Mockito.when(sin.of(AdditionalMatchers.eq(-0.8, 0.1))).thenReturn(-0.717);
        Mockito.when(sin.of(AdditionalMatchers.eq(2.48, 0.1))).thenReturn(0.614);

        Mockito.when(sin.of(Double.POSITIVE_INFINITY)).thenReturn(Double.NaN);
        Mockito.when(sin.of(Double.NEGATIVE_INFINITY)).thenReturn(Double.NaN);
        Mockito.when(sin.of(Double.NaN)).thenReturn(Double.NaN);

        return sin;
    }
    public static Tan getTanMock() {
        Tan tan = Mockito.mock(Tan.class);

        Mockito.when(tan.of(AdditionalMatchers.eq(-1.2, 0.1))).thenReturn(-2.572);
        Mockito.when(tan.of(AdditionalMatchers.eq(0.165, 0.1))).thenReturn(0.167);
        Mockito.when(tan.of(AdditionalMatchers.eq(0.465, 0.1))).thenReturn(0.495);
        Mockito.when(tan.of(AdditionalMatchers.eq(2.2, 0.1))).thenReturn(-1.374);
        Mockito.when(tan.of(AdditionalMatchers.eq(0.0, 0.1))).thenReturn(0.0);


        Mockito.when(tan.of(Double.POSITIVE_INFINITY)).thenReturn(Double.NaN);
        Mockito.when(tan.of(Double.NEGATIVE_INFINITY)).thenReturn(Double.NaN);
        Mockito.when(tan.of(Double.NaN)).thenReturn(Double.NaN);

        return tan;
    }

    public static Ln getLnMock() {
        Ln ln = Mockito.mock(Ln.class);

        Mockito.when(ln.of(AdditionalMatchers.eq(1.0, 0.1))).thenReturn(0.0);
        Mockito.when(ln.of(AdditionalMatchers.eq(2.0, 0.1))).thenReturn(0.693);
        Mockito.when(ln.of(AdditionalMatchers.eq(3.0, 0.1))).thenReturn(1.099);
        Mockito.when(ln.of(AdditionalMatchers.eq(5.0, 0.1))).thenReturn(1.609);
        Mockito.when(ln.of(AdditionalMatchers.eq(10.0, 0.1))).thenReturn(2.302);
        Mockito.when(ln.of(AdditionalMatchers.eq(0.0, 0.1))).thenReturn(Double.NaN);
        Mockito.when(ln.of(AdditionalMatchers.eq(-1.0, 0.1))).thenReturn(Double.NaN);
        Mockito.when(ln.of(AdditionalMatchers.eq(0.44, 0.1))).thenReturn(-0.821);
        Mockito.when(ln.of(AdditionalMatchers.eq(0.67, 0.1))).thenReturn(-0.4);
        Mockito.when(ln.of(AdditionalMatchers.eq(5.33, 0.1))).thenReturn(1.673);

        Mockito.when(ln.of(Double.POSITIVE_INFINITY)).thenReturn(0.0);
        Mockito.when(ln.of(Double.NEGATIVE_INFINITY)).thenReturn(Double.NaN);
        Mockito.when(ln.of(Double.NaN)).thenReturn(Double.NaN);

        return ln;
    }
    public static Log2 getLog2Mock() {
        Log2 log2 = Mockito.mock(Log2.class);

        Mockito.when(log2.of(AdditionalMatchers.eq(2.3, 0.1))).thenReturn(1.202);

        return log2;
    }
    public static Log3 getLog3Mock() {
        Log3 log3 = Mockito.mock(Log3.class);

        Mockito.when(log3.of(AdditionalMatchers.eq(2.3, 0.1))).thenReturn(0.785);

        return log3;
    }
    public static Log5 getLog5Mock() {
        Log5 log5 = Mockito.mock(Log5.class);

        Mockito.when(log5.of(AdditionalMatchers.eq(2.3, 0.1))).thenReturn(0.518);

        return log5;
    }
    public static Log10 getLog10Mock() {
        Log10 log10 = Mockito.mock(Log10.class);

        Mockito.when(log10.of(AdditionalMatchers.eq(2.3, 0.1))).thenReturn(0.362);

        return log10;
    }


}
