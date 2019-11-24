package test.thread.aqs;

import org.junit.Test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test1 {
    Lock lock = new ReentrantLock();

    @Test
    public void tets1(){
        lock.lock();
        new Thread(()->
                lock.lock())
                .start();
        System.out.println(1);
    }
}
