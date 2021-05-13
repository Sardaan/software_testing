package lab1.math;

public class Function {
    private Function(){}

    public static double arctg(double a){
        if (Math.abs(a) >= 1)
            throw new IllegalArgumentException("|a| must be < 1");

        double result = 0.0;
        for(int n = 0; n < 1000; n++){
            result += Math.pow(-1, n)*Math.pow(a, (2*n+1))/(2*n+1);
        }
        return result;
    }
}



