package lab2.logarithm;

import lab2.Function;

public class Log2 implements Function {

    private final Ln ln = new Ln();
    @Override
    public double of(double x) {
        return ln.of(x) / ln.of(2.0);
    }
}
