package test.thread;

import org.junit.Test;

import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadPool {
    ThreadPoolExecutor pool;
    Lock lock = new ReentrantLock();


    @Test
    public void test1(){
//        pool = new ThreadPoolExecutor(10,10,1000, TimeUnit.SECONDS,
//                new ArrayBlockingQueue<>(2));
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(10);
        Condition condition = lock.newCondition();
//        condition.

    }
}
