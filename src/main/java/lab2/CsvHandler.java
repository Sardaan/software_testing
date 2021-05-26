package lab2;

import lab2.logarithm.*;
import lab2.trigonometry.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class CsvHandler {

    private final FunctionSystem functionSystem = new FunctionSystem();

    private final Sin sin = new Sin();
    private final Cos cos = new Cos();
    private final Cot cot = new Cot();
    private final Tan tan = new Tan();
    private final Sec sec = new Sec();

    private final Ln ln = new Ln();
    private final Log2 log2 = new Log2();
    private final Log3 log3 = new Log3();
    private final Log5 log5 = new Log5();
    private final Log10 log10 = new Log10();

    void createCSV(double from, double to, double step) {

        try (PrintWriter writer = new PrintWriter(new File("test.csv"))) {
            StringBuilder sb = new StringBuilder();
            double cur;
            cur = from;
            sb.append("X, Y, sin(X), cos(X), tan(X), cot(X), sec(X), ln(X), log_2(X), log_3(X), log_5(X), log_10(X) \n");
            while (cur < to) {
                sb.append(cur).append(", ").append(functionSystem.system(cur)).append(", ").append(sin.of(cur)).append(", ").append(cos.of(cur))
                        .append(", ").append(tan.of(cur)).append(", ").append(cot.of(cur)).append(", ").append(sec.of(cur)).append(", ")
                        .append(ln.of(cur)).append(", ").append(log2.of(cur)).append(", ").append(log3.of(cur)).append(", ")
                        .append(log5.of(cur)).append(", ").append(log10.of(cur)).append("\n");
                cur += step;
            }
            writer.write(sb.toString());
            writer.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
