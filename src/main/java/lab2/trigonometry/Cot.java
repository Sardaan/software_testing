package lab2.trigonometry;

import lab2.Function;

public class Cot implements Function {

    private Tan tan = new Tan();
    @Override
    public double of(double x) {
        return 1 / tan.of(x);
    }

    public void setTan(Tan tan){
        this.tan = tan;
    }
}
