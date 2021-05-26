package lab2;

import lab2.logarithm.*;
import lab2.trigonometry.*;

import static java.lang.Math.pow;

import java.io.*;
//x <= 0 : (((((sin(x) * sin(x)) ^ 2) / cot(x)) / ((sec(x) / (sin(x) / tan(x))) + (sin(x) - sec(x)))) ^ 2)
//x > 0 : (((((log_5(x) / log_2(x)) - log_2(x)) - log_3(x)) - (log_10(x) ^ 3)) + (log_10(x) * log_10(x)))

public class FunctionSystem {

    public static final double PRECISION = 0.0001;

    private final Sin sin = new Sin();
    private final Cot cot = new Cot();
    private final Tan tan = new Tan();
    private final Sec sec = new Sec();

    private final Log2 log2 = new Log2();
    private final Log3 log3 = new Log3();
    private final Log5 log5 = new Log5();
    private final Log10 log10 = new Log10();


    public double system(double x) {
        double equation;
        if (x > 0) equation = (((((log5.of(x) / log2.of(x)) - log2.of(x)) - log3.of(x)) - pow(log10.of(x), 3)) + (log10.of(x) * log10.of(x)));
        else equation = pow(((pow((sin.of(x) * sin.of(x)), 2) / cot.of(x)) / ((sec.of(x) / (sin.of(x) / tan.of(x))) + (sin.of(x) - sec.of(x)))), 2);


        return equation;
    }

}

