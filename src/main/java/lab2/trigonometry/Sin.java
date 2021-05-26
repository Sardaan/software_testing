package lab2.trigonometry;

import lab2.Function;
import static lab2.FunctionSystem.PRECISION;

import static java.lang.Math.PI;
import static java.lang.Math.abs;

public class Sin implements Function {

    @Override
    public double of(double x){
        if (Double.isNaN(x) || Double.isInfinite(x)) {
            return Double.NaN;
        }
        double x1 = x % (2 * PI);
        if (abs(abs(x1) - PI) < PRECISION || abs(abs(x1) - 2 * PI) < PRECISION || abs(abs(x1) - 0.0) < PRECISION) {
            return 0.0;
        }
        return sin(x1, x1, 1, 0);
    }

    private double sin(double x, double current, int n, double result) {
        if (abs(current) < PRECISION) return result;
        return sin(x, current * (-x * x / (2.0 * n * (2.0 * n + 1.0))), n + 1, result + current);
    }

}
