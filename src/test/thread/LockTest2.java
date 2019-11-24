package test.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest2 implements Runnable{
    Lock lock = new ReentrantLock();


    public static void main(String[] args) {
        LockTest2 lockTest2 = new LockTest2();

        new  Thread(lockTest2).start();
        new  Thread(lockTest2).start();
    }

    @Override
    public void run() {
        lock.lock();
        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());
        }
    }
}
