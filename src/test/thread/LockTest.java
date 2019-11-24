package test.thread;

public class LockTest implements Runnable{
    static  int a = 10;


    public static void main(String[] args) throws InterruptedException {
        LockTest t1 = new LockTest();
        LockTest t2 = new LockTest();
        Thread thread1 = new Thread(t1, "thread1");
        Thread thread2 = new Thread(t1, "thread2");
        thread1.start();
        thread2.start();
        System.out.println("等待");
        thread1.join();
        thread2.join();
        System.out.println("结束");

    }
    @Override
    public void run() {
        try {
            lock1();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private  synchronized void lock1() throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        other();
        while (true){
//            Thread.sleep(1000);
        }
    }

    private synchronized void other(){
        System.out.println("执行不了");
    }
}
