package lab2;

import lab2.logarithm.*;
import lab2.trigonometry.*;

import static java.lang.Math.pow;

import java.io.*;
//x <= 0 : (((((sin(x) * sin(x)) ^ 2) / cot(x)) / ((sec(x) / (sin(x) / tan(x))) + (sin(x) - sec(x)))) ^ 2)
//x > 0 : (((((log_5(x) / log_2(x)) - log_2(x)) - log_3(x)) - (log_10(x) ^ 3)) + (log_10(x) * log_10(x)))

public class FunctionSystem {

    public static final double PRECISION = 0.0001;

    private Sin sin = new Sin();
    private Cos cos = new Cos();
    private Cot cot = new Cot();
    private Tan tan = new Tan();
    private Sec sec = new Sec();

    private Ln ln = new Ln();
    private Log2 log2 = new Log2();
    private Log3 log3 = new Log3();
    private Log5 log5 = new Log5();
    private Log10 log10 = new Log10();


    public double system(double x) {
        double equation;
        if (x > 0) equation = (((((log5.of(x) / log2.of(x)) - log2.of(x)) - log3.of(x)) - pow(log10.of(x), 3)) + (log10.of(x) * log10.of(x)));
        else equation = pow(((pow((sin.of(x) * sin.of(x)), 2) / cot.of(x)) / ((sec.of(x) / (sin.of(x) / tan.of(x))) + (sin.of(x) - sec.of(x)))), 2);


        return equation;
    }

    public void setSin(Sin sin) {
        this.sin = sin;
    }
    public void setCos(Cos cos) {
        this.cos = cos;
    }
    public void setCot(Cot cot) {
        this.cot = cot;
    }
    public void setTan(Tan tan) {
        this.tan = tan;
    }
    public void setSec(Sec sec) {
        this.sec = sec;
    }

    public void setLn(Ln ln) { this.ln = ln; }
    public void setLog2(Log2 log2) {
        this.log2 = log2;
    }
    public void setLog3(Log3 log3) {
        this.log3 = log3;
    }
    public void setLog5(Log5 log5) {
        this.log5 = log5;
    }
    public void setLog10(Log10 log10) {
        this.log10 = log10;
    }
}

