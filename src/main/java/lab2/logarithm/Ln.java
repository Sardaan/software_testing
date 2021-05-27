package lab2.logarithm;

import lab2.Function;

import static java.lang.Math.abs;
import static lab2.FunctionSystem.PRECISION;

public class Ln implements Function {

    @Override
    public double of(double x) {
        if (x <= 0 || Double.isNaN(x))
            return Double.NaN;
        else if (Double.isInfinite(x) && x > 0 )
            return 0.0;
        double x1 = (x - 1) / (x + 1);
        double current = x1;
        double result = 0.0;
        int n = 3;
        while (abs(2 * current) > PRECISION / 10) {
            result += 2 * current;
            current *= x1 * x1 / n * (n - 2);
            n += 2;
        }
        return result;
    }
}
