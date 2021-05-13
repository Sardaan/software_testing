package lab1.math;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FunctionTest {
    private static final double DELTA = 0.001;

    @Test
    void arctgZeroTest(){
        assertEquals(0, Function.arctg(0));
    }

    @Test
    void arctgZeroSignedTest() {
        assertEquals(-0, Function.arctg(-0));
    }

    @Test
    void arctgNearZeroPlusDeltaTest() {
        assertNotEquals(0, Function.arctg(DELTA));
        assertEquals(0.0009999996666668666, Function.arctg(DELTA), DELTA);
    }

    @Test
    void arctgNearZeroMinusDeltaTest() {
        assertNotEquals(0, Function.arctg(-DELTA));
        assertEquals(-0.0009999996666668666, Function.arctg(-DELTA), DELTA);
    }


    @Test
    void arctgNaNTest() {
        assertEquals(Double.NaN, Function.arctg(Double.NaN));
    }

    @Test
    void arctgOneTest(){
        assertThrows(IllegalArgumentException.class, () -> Function.arctg(1));
    }

    @Test
    void arctgOnePlusDeltaTest(){
        assertThrows(IllegalArgumentException.class, () -> Function.arctg(1+DELTA));
    }

    @Test
    void arctgMinusOneMinusDeltaTest(){
        assertThrows(IllegalArgumentException.class, () -> Function.arctg(-1-DELTA));
    }

    @Test
    void arctgInfTest() {
        assertThrows(IllegalArgumentException.class, () -> Function.arctg(Double.POSITIVE_INFINITY));
        assertThrows(IllegalArgumentException.class, () -> Function.arctg(Double.NEGATIVE_INFINITY));
    }

    @Test
    void arctgHalfOneTest() {
        assertEquals(0.4636476090008061, Function.arctg(0.5), DELTA);
    }

    @Test
    void arctgHalfOnePlusDeltaTest() {
        assertEquals(0.46444728895829296, Function.arctg(0.5 + DELTA), DELTA);
    }

    @Test
    void arctgMinusHalfOnePlusDeltaTest() {
        assertEquals(-0.4628472890436265, Function.arctg(-0.5 + DELTA), DELTA);
    }

    @Test
    void arctgMinusHalfOneTest() {
        assertEquals(-0.4636476090008061, Function.arctg(-0.5), DELTA);
    }

    @Test
    void arctgMinusOnePlusDeltaTest() {
        assertEquals(-0.784897913314115, Function.arctg(-1 + DELTA), DELTA);
    }
    @Test
    void arctgOneMinusDeltaTest() {
        assertEquals(0.784897913314115, Function.arctg(1-DELTA), DELTA);
    }

}
