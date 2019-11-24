package test.thread.producer;

import org.junit.Test;

import java.util.concurrent.locks.Lock;

public class ReentrantLock {
    Lock lock = new java.util.concurrent.locks.ReentrantLock();

    @Test
    public void test1(){
        lock.lock();
        lock.unlock();
    }
}
