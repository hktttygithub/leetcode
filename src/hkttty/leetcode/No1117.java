package hkttty.leetcode;

import java.util.concurrent.Semaphore;

public class No1117 {
    static class H2O {
        static Semaphore hSemaphore = new Semaphore(0);
        static Semaphore oSemaphore = new Semaphore(0);

        public H2O() {

        }

        public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
            hSemaphore.release(1);
            oSemaphore.acquire(1);
            // releaseHydrogen.run() outputs "H". Do not change or remove this line.
            releaseHydrogen.run();
        }

        public void oxygen(Runnable releaseOxygen) throws InterruptedException {
            oSemaphore.release(1);
            hSemaphore.acquire(2);
            // releaseOxygen.run() outputs "H". Do not change or remove this line.
            releaseOxygen.run();
        }
    }

    public static void main(String[] args) {
//        for(int i=0;i<10;i++){
//            new Thread(()->H2O.)
//        }
    }
}
