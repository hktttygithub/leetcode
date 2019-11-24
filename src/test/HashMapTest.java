package test;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class HashMapTest implements Runnable{
//    public static HashMap<Integer, Integer> map = new HashMap<>();
    static ConcurrentHashMap <Integer, Integer> map = new ConcurrentHashMap<>();
    static AtomicInteger i = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        HashMapTest tTest = new HashMapTest();
        Thread t = new Thread(tTest);
        Thread t2 = new Thread(tTest);
        Thread t3 = new Thread(tTest);
        Thread t4 = new Thread(tTest);
        Thread t5 = new Thread(tTest);
        t.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();


        t2.join();
        t3.join();
        t4.join();
        t4.join();
        t5.join();
//        for(int i : map.keySet()){
//            System.out.println("key: " + i + "  value: " + map.get(i));
//        }
        System.out.println(map.size());
    }

    @Override
    public void run() {
        int b=0;
        while (b<1000000) {
            map.put(i.getAndIncrement(), 100);
            b++;
        }
    }
}
