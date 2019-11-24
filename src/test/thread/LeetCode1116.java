package test.thread;

import org.junit.Test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LeetCode1116 {

    private int n = 100;
    volatile int flag = 0;
    volatile static int i = 1;
    static Lock lock = new ReentrantLock();

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        try {

            while (true) {
                while (flag!=0) {
                    try {
                        lock.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                printNumber.accept(0);
                if (i % 2 != 0) {
                    flag =1;
                } else {
                    flag = 2;
                }
                lock.notifyAll();
                if (i == n) {
                    break;
                }
            }
        }finally {
            lock.unlock();
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        try {

            while (i <= n) {
                while (flag!=1) {
                    try {
                        lock.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                printNumber.accept(i);
                flag = 0;
                i++;
                lock.notifyAll();
            }
        }finally {
            lock.unlock();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        try{
            while (i <= n) {
                while (flag!=2) {
                    try {
                        lock.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                printNumber.accept(i);
                flag = 0;
                i++;
                lock.notifyAll();
            }
        }finally {
            lock.unlock();
        }
    }

    @Test
    public void test1() {
        try {
            new Thread(() -> {
                try {
                    zero(new IntConsumer());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
            new Thread(() -> {
                try {
                    even(new IntConsumer());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
            Thread thread = new Thread(() -> {
                try {
                    odd(new IntConsumer());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            thread.start();
            thread.join();

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("final");
    }


    class IntConsumer {

        public void accept(int i) {
            System.out.print(i + "");
        }
    }

}
