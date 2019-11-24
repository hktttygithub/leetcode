package test.thread.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zhengbinMac on 2017/2/20.
 */
class Depot {
    private int capacity;
    private int size;
    private Lock lock;
    private Condition consumerCond;
    private Condition produceCond;

    public Depot(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.lock = new ReentrantLock();
        this.consumerCond = lock.newCondition();
        this.produceCond = lock.newCondition();
    }

    public void produce(int val) {
        lock.lock();
        try {
            int left = val;
            while (left > 0) {
                while (size >= capacity) {
                    produceCond.await();
                }
                int produce = (left + size) > capacity ? (capacity - size) : left;
                size += produce;
                left -= produce;
                System.out.println(Thread.currentThread().getName() + ", ProduceVal=" + val + ", produce=" + produce + ", size=" + size);
                consumerCond.signalAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void consumer(int val) {
        lock.lock();
        try {
            int left = val;
            while (left > 0) {
                while (size <= 0) {
                    consumerCond.await();
                }
                int consumer = (size <= left) ? size : left;
                size -= consumer;
                left -= consumer;
                System.out.println(Thread.currentThread().getName() + ", ConsumerVal=" + val + ", consumer=" + consumer + ", size=" + size);
                produceCond.signalAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

class Consumer {
    private Depot depot;

    public Consumer(Depot depot) {
        this.depot = depot;
    }

    public void consumerThing(final int amount) {
        new Thread(new Runnable() {
            public void run() {
                depot.consumer(amount);
            }
        }).start();
    }
}

class Produce {
    private Depot depot;

    public Produce(Depot depot) {
        this.depot = depot;
    }

    public void produceThing(final int amount) {
        new Thread(new Runnable() {
            public void run() {
                depot.produce(amount);
            }
        }).start();
    }
}

public class ConditionTest {
    public static void main(String[] args) {
        // 仓库
        Depot depot = new Depot(100);
        // 消费者
        Consumer consumer = new Consumer(depot);
        // 生产者
        Produce produce = new Produce(depot);
        produce.produceThing(5);
        consumer.consumerThing(5);
        produce.produceThing(2);
        consumer.consumerThing(5);
        produce.produceThing(3);
    }
}