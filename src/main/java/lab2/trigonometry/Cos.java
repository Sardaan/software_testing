package lab2.trigonometry;

import lab2.Function;

import static java.lang.Math.PI;
import static java.lang.Math.sqrt;

public class Cos implements Function {

    private final Sin sin = new Sin();

    @Override
    public double of(double x) {
        int sign;
        if (((x % (2.0 * PI)) < PI / 2) && ((x % (2.0 * PI)) > -PI / 2) ||
                ((x % (2.0 * PI)) < -1.5 * PI) || ((x % (2.0 * PI)) > 1.5 * PI)
        ) {
            sign = 1;
        } else {
            sign = -1;
        }
        return sqrt(1.0 - sin.of(x) * sin.of(x)) * sign;
    }
}
