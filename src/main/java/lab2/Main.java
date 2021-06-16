package lab2;

import static java.lang.Math.PI;

public class Main {

    public static void main(String[] args) {
        CsvHandler csvHandler = new CsvHandler();
        csvHandler.createCSV(-2 * PI, 3.0, 0.1);
    }


}

