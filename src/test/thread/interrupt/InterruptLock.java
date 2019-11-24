package test.thread.interrupt;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class InterruptLock {
    static Lock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->tryAcquire1());
//        Thread t2 = new Thread(()->tryAcquire());
        t1.start();
//        t2.start();
//        Thread.sleep(2000);
//        Thread.sleep(2000);
//        t1.interrupt();
        boolean b = lock.tryLock(5,TimeUnit.SECONDS);
        System.out.println(b);
        lock.unlock();
    }

    private static void tryAcquire1() {
        try {
            System.out.println(Thread.currentThread().getName() + "尝试获取锁");
            lock.lockInterruptibly();
//            boolean b = lock.tryLock();
//            lock.lock();
//            boolean b = lock.tryLock(10, TimeUnit.SECONDS);
            System.out.println(Thread.currentThread().getName() + "成功获取锁");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.print(Thread.currentThread().getName());
            System.out.println("被中断，不再获取锁");
        }finally {
//            lock.unlock();
            lock.unlock();
            System.out.println("?");
        }


    }
}
