package hkttty;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class Test {
    static ConcurrentHashMap<Integer,Integer> map = new ConcurrentHashMap<>();
    static HashMap<Integer,Integer> map2 = new HashMap<>();
    static AtomicInteger exist = new AtomicInteger();
    static AtomicInteger notExist = new AtomicInteger();
    static CountDownLatch latch = new CountDownLatch(10000);

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        for(int i=0;i<10000;i++){
            new Thread(()->test1()).start();
        }
        latch.await();
        System.out.println(exist);
        System.out.println(notExist);
        System.out.println("time:" + (System.currentTimeMillis() - start));
    }

    private static void test1() {
        if(!map.containsKey(1)){
            System.out.println("no");
            map.put(1,1);
            exist.incrementAndGet();
        }else{
            System.out.println("..");
            notExist.incrementAndGet();
        }
        latch.countDown();
    }


}
