package lab2.trigonometry;

import lab2.Function;

public class Tan implements Function {

    private final Sin sin = new Sin();
    private final Cos cos = new Cos();
    @Override
    public double of(double x) {
        return sin.of(x) / cos.of(x);
    }
}
