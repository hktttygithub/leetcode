package test.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SynchronizedTest implements Runnable{
    Lock lock = new ReentrantLock();

    public void run(){
//        lock.lockInterruptibly();
        test1();
    }

    private   void test1() {
        synchronized (SynchronizedTest.class){
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("break");
        }

    }


    public static void main(String[] args) {
        SynchronizedTest t1 = new SynchronizedTest();
        SynchronizedTest t2 = new SynchronizedTest();
        new Thread(t1).start();
        new Thread(t2).start();
    }
}
