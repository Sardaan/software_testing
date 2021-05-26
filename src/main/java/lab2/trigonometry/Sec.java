package lab2.trigonometry;

import lab2.Function;

public class Sec implements Function {

    private final Cos cos = new Cos();
    @Override
    public double of(double x) {
        return 1 / cos.of(x);
    }
}
