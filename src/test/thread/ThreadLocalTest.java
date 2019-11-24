package test.thread;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalTest implements Runnable{
    @Test
    public void testThreadLocals() throws InterruptedException {
        ThreadLocalTest count = new ThreadLocalTest();
        ExecutorService es = Executors.newFixedThreadPool(100);
        for(int i=0;i<100;i++){
            es.execute(count);
        }
        es.shutdown();
        while(!es.isTerminated()){
            Thread.sleep(3000);
        }
    }

    private static ThreadLocal<Integer> localcount = ThreadLocal.withInitial(()->0);

    public int getLocalCount() {
        localcount.set(localcount.get()+1);
        return localcount.get();
    }

    @Override
    public void run() {
        for(int i =0;i<3;i++){
            Double d = Math.random() * 1000;
//            try {
//                Thread.sleep(d.longValue());
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            System.out.println(Thread.currentThread().getName()+": "+getLocalCount());
        }
    }

    ThreadLocal<String> str = ThreadLocal.withInitial(()->"dss");

    @Test
    public void test1(){
        String s = str.get();
        System.out.println(s);
    }
}
