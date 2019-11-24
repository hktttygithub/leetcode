package test.interrupt;

import org.junit.Test;

public class InterruptTest {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (!Thread.currentThread().interrupted()) {
                try {
                    System.out.println("睡觉");
                    Thread.sleep(20000);

                } catch (Exception e) {
                    System.out.println("被打断");
                    break;
                }
            }
            System.out.println("终止");
        });
        thread.start();
        Thread.sleep(5000);

// 一段时间以后
        thread.interrupt();

    }

    @Test
    public void test1() throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (true) {
                    synchronized (this){
                        try {
                            System.out.println("wait");
                            this.wait();
                        } catch (InterruptedException e) {
                            System.out.println("终止");
                            break;
                        }
                    }
            }
        });
        thread.start();

        Thread.sleep(1000);
        thread.interrupt();
        Thread.sleep(1000);
    }
}
