package utils;

import java.util.concurrent.TimeUnit;

public class Wait {
    public static void sleepFor(Long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Thread was interrupted\n" + e.getMessage());
        }
    }
}
