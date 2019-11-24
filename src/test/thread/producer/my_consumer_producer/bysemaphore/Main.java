package test.thread.producer.my_consumer_producer.bysemaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    static final AtomicInteger stock = new AtomicInteger(0);
    static volatile int maxSize;
    static Semaphore producterSempahre;
    static Semaphore consumerSempahre;

    Main(int maxSize) {
        this.maxSize = maxSize;
        producterSempahre = new Semaphore(maxSize);
        consumerSempahre = new Semaphore(0);
    }

    public static void main(String[] args) {
        new Main(10);

//        System.out.println(stock.get());
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> product());
            thread.setName("product" + i);
            thread.start();
        }
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(() -> consumer());
            thread.setName("consumer" + i);
            thread.start();
        }

    }

    private static void consumer() {
        while (true) {
            try {
                consumerSempahre.acquire();
                int curCount = stock.decrementAndGet();
//                System.out.println();
                System.out.println("当前消费线程:" + Thread.currentThread().getName() + "消费后商品数量:" + curCount);
                producterSempahre.release();

                if (stock.get() > maxSize || stock.get() < 0) {
                    throw new Exception();
                }
//                Thread.sleep(10);
            } catch (Exception e) {
                System.out.println("error");
                System.exit(0);
            }
        }
    }

    static private void product() {
        while (true) {
            try {
                producterSempahre.acquire();
                int curCount = stock.incrementAndGet();
//                System.out.println("当前生产线程:" + Thread.currentThread().getName());
                System.out.println("当前生产者线程:" + Thread.currentThread().getName() + "生产后商品数量:" + curCount);
                consumerSempahre.release();
                if (stock.get() > maxSize || stock.get() < 0) {
                    throw new Exception();
                }
//                Thread.sleep(10);
            } catch (Exception e) {
                System.out.println("error");
                System.exit(0);
            }
        }
    }
}
