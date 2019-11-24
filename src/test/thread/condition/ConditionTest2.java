package test.thread.condition;

import java.util.HashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTest2 {
    static int count = 1;
    static Lock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();
    static HashMap<String,Condition> map = new HashMap<>();

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(() -> print()).start();
        }
        new Thread(()->signal()).start();

    }

    private static void signal() {
        try {
            lock.lock();
            Thread.sleep(1000);
            Condition condition = map.get("Thread-4");
            condition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }

    static void print() {
       try{
           lock.lock();
           System.out.println("开始:" + System.currentTimeMillis()  + "..." + Thread.currentThread().getName());
           Condition condition = lock.newCondition();
           map.put(Thread.currentThread().getName(),condition);
           condition.await();
           System.out.println("结束:" + System.currentTimeMillis() + "..." + Thread.currentThread().getName());

       } catch (InterruptedException e) {
           e.printStackTrace();
       } finally {
           lock.unlock();
       }

    }
}
