package hkttty.enumTest;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public enum Singleton_3 {
    INSTANCE;

    Singleton_3() {
    }

    public void printHello() {
        System.out.println("Hello");
    }

    public static void main(String[] args) throws Exception {
        Integer loopNum = 100;
//        Integer loopNum = 1000;
        Set<Object> instanceSet = new HashSet<>();
        ExecutorService executor = Executors.newCachedThreadPool();
        CountDownLatch countDownLatch = new CountDownLatch(loopNum);
        for (int i = 0; i < loopNum; i++) {
            executor.execute(() -> {
                Singleton_3 instance = Singleton_3.INSTANCE;
                instance.printHello();
                instance.printHello();
//                instanceSet.add(obj);
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executor.shutdown();

        System.out.println(instanceSet);

    }
}