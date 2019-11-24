package test.thread;

import org.junit.Test;

public class ThreadLocalTest2 implements Runnable {

    static ThreadT t2 = new ThreadT();


    static ThreadLocal<ThreadT> count = ThreadLocal.withInitial(()->t2);

    @Test
    public void go() {
        ThreadLocalTest2 t1 = new ThreadLocalTest2();
        for (int i = 0; i < 10; i++) {
            new Thread(t1).start();
        }
    }


    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            ThreadT t = count.get();
            t.a = t.a + 100;
            count.set(t);
        }
        System.out.println(Thread.currentThread().getName() + " :  " + count.get().a);
    }

    static class ThreadT{
         int a = 0;
    }
}
