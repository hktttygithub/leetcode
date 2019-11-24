package test.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    static CyclicBarrier barrier = new CyclicBarrier(3);

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new Thread(() -> test1()).start();
        }

    }

    private static void test1() {
        try {
            for (int i = 0; i < 2; i++) {
                System.out.println(Thread.currentThread().getName() + "抵达栅栏");
                barrier.await();
                System.out.println(Thread.currentThread().getName() + "冲破栅栏");
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

    }


}
