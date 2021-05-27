package lab2.trigonometry;

import lab2.Function;

public class Sec implements Function {

    private Cos cos = new Cos();
    @Override
    public double of(double x) {
        return 1 / cos.of(x);
    }

    public void setCos(Cos cos){
        this.cos = cos;
    }
}
