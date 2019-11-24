package test.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class Cas2{
    static AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            Thread thread = new Thread(() -> add());
            thread.start();
        }
        Thread.sleep(2000);
        System.out.println("count:" + count.get());
    }

    private static void add() {
        for (int i = 0; i < 10000; i++) {
            count.incrementAndGet();
        }
    }

}
