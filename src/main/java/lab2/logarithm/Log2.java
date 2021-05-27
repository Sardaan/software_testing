package lab2.logarithm;

import lab2.Function;

public class Log2 implements Function {

    private Ln ln = new Ln();
    @Override
    public double of(double x) {
        if (Double.isInfinite(x) && x > 0 )
            return 0.0;
        return ln.of(x) / ln.of(2.0);
    }

    public void setLn(Ln ln){
        this.ln = ln;
    }
}
