package lab3;

public class Util {
    public static void timeOut(long seconds) throws InterruptedException {
        Thread.sleep(seconds * 1000);
    }
}
