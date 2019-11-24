package test.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest2 implements Runnable {
    static int a;
    private final Lock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        ThreadTest2 t1 = new ThreadTest2();
        Thread thread = new Thread(t1);
        Thread thread2 = new Thread(t1);
        thread.start();
        thread2.start();
        Thread.sleep(2000);
        a=100;
    }

    @Override
    public void run() {
        lock.lock();
        try {
            a=0;
            System.out.println(Thread.currentThread().getName());
            while (true){
                Thread.sleep(1000);
                System.out.println(a);
                a++;
                if(a==10){
                    break;
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
