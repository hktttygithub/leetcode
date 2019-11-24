package test.thread.pool;

import org.junit.Test;

import java.util.concurrent.*;

public class ThreadPool {
    static int i = 0;

    ThreadPoolExecutor pool = new ThreadPoolExecutor(30, 30, 60,
            TimeUnit.SECONDS, new LinkedBlockingDeque<>());

    static ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
    static ExecutorService fixedThreadPool = Executors.newFixedThreadPool(10);
    static ExecutorService singleThreadPool = Executors.newSingleThreadExecutor();
    static ExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(10);

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {


        Future<String> submit = fixedThreadPool.submit(() -> {
//                System.out.println("123");
            Thread.sleep(3000);
            return "123";
        });

//            Thread.sleep(100);

        System.out.println("submit");
        System.out.println(submit.get(1,TimeUnit.SECONDS));
        Thread.sleep(4000);
        System.out.println(submit.get());

    }


    @Test
    public void test1() throws InterruptedException {
        int a = 10;
        for (int i = 0; i < 30; i++) {
            DoSomething d1 = new DoSomething();
            d1.setA(a);
            a = a + 10;
            pool.execute(d1);
        }
        Thread.sleep(5000);
    }

}
