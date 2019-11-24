package test.thread.interrupt;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class InterruptTest {
    static Lock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> toWait3());
        thread.start();
        Thread.sleep(2000);
        thread.interrupt();
    }


    private static void toWait() {
        synchronized (InterruptTest.class) {
            try {
                System.out.println("阻塞/等待");
                Thread.sleep(10000);
//                InterruptTest.class.wait();
            } catch (Exception e) {
                System.out.println("抛异常会重置interrupt" + Thread.interrupted());
                System.out.println("被打断");
            }
        }

    }

    private static void toWait2() {
        int i = 1000;
        synchronized (InterruptTest.class) {
            try {
                while (!Thread.interrupted()) {
                    i++;
                }
            } catch (Exception e) {
                System.out.println(Thread.interrupted());
                System.out.println("被打断");
                System.out.println(i);
            }
            System.out.println(i);
        }

    }

    private static void toWait3() {
        try {
            lock.lock();
            Condition condition = lock.newCondition();
            System.out.println("进入阻塞/等待状态");
//            condition.await();
            Thread.sleep(100000);
        } catch (Exception e) {
            System.out.println("等待/阻塞被打断");
        } finally {
            lock.unlock();
        }
    }

}
