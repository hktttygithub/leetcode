package hkttty.leetcode;

import java.util.concurrent.Semaphore;

public class No1117_Re {
    class H2O {
        Semaphore h=  new Semaphore(2);
        Semaphore o=  new Semaphore(0);

        public H2O() {

        }

        public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
            h.acquire();
            // releaseHydrogen.run() outputs "H". Do not change or remove this line.
            releaseHydrogen.run();
            o.release();
        }

        public void oxygen(Runnable releaseOxygen) throws InterruptedException {
            o.acquire(2);
            // releaseOxygen.run() outputs "H". Do not change or remove this line.
            releaseOxygen.run();
            h.release(2);
        }
    }
}
