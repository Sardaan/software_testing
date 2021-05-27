package lab2.trigonometry;

import lab2.Function;

public class Tan implements Function {

    private Sin sin = new Sin();
    private Cos cos = new Cos();
    @Override
    public double of(double x) {
        return sin.of(x) / cos.of(x);
    }

    public void setSin(Sin sin){
        this.sin = sin;
    }

    public void setCos(Cos cos){
        this.cos = cos;
    }
}
