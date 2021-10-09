package lab3.utils;

public class Util {
    public static void timeOut(long seconds) throws InterruptedException {
        Thread.sleep(seconds * 1000);
    }
}
