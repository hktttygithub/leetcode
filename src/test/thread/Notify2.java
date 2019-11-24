package test.thread;

import org.junit.Test;

public class Notify2 {
    int n =2;
    volatile boolean fooPrint = true;

    @Test
    public void test1() throws InterruptedException {
        while(true) {
            Thread t1 = new Thread(() -> {
                try {
                    foo();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            Thread t2 = new Thread(() -> {
//                this.notifyAll();
                try {
                    bar();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            t1.start();
            t2.start();

            try {
                t1.join();
                t2.join();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("final");
        }
    }

    public void foo() throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized(this){
                while(!fooPrint){
                    try{
                        this.wait();
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }
                System.out.println("foo");
                fooPrint = false;
                this.notify();
//                this.wait();
            }
        }
    }

    public void bar() throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized(this){
                while(fooPrint){
                    try{
                        this.wait();
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }
                System.out.println("bar");
                fooPrint = true;
                this.notify();
//                this.wait();
            }
        }
    }
}
