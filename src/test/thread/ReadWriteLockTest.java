package test.thread;

import org.junit.Test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockTest {
    Lock lock = new ReentrantLock();
    private static int a=0;
    private final ReadWriteLock rwLock = new ReentrantReadWriteLock();
    private final Lock readLock = rwLock.readLock();
    private final Lock writeLock = rwLock.writeLock();

    public void reader(){
        readLock.lock();
        try {
            while (true){
                Thread.sleep(1000);
                System.out.println(a);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            readLock.unlock();
        }
    }

    public void writer() throws InterruptedException {
        writeLock.lock();
        try {
            a=100;
            System.out.println(a);
        }finally {
            writeLock.unlock();
        }
    }

    @Test
    public void test1() throws InterruptedException {
        Thread thread = new Thread(() -> reader());
        thread.start();
        writer();
        thread.join();
    }
}
