package test.thread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Cas {
    static volatile int val = 0;
    static AtomicInteger count = new AtomicInteger(0);

    static Lock lock = new ReentrantLock();

    /*compare_and_swap (*p, oldval, newval):
      if (*p == oldval)
          *p = newval;
          success;
      else
         fail;*/

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10000; i++) {
            new Thread(() -> add()).start();
        }
        Thread.sleep(1000);
        System.out.println(val);
        System.out.println("count:" + count);
    }

    private static void add() {
        do {
            if (compareAndSwap(val, val + 1))
                break;
        }
        while (true);

    }

    //这个方法应该是一个原子操作，由硬件来保证它的原子性
    private static boolean compareAndSwap(int oldValue, int newValue) {
        if (oldValue == val) {
            val = newValue;
            return true;
        }
        return false;
    }

}
