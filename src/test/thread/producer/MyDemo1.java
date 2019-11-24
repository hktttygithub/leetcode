package test.thread.producer;


import java.util.LinkedList;

public class MyDemo1 {
    static LinkedList<String> list = new LinkedList();
    volatile int maxCount = 100;

    class Product implements Runnable{
        @Override
        public void run() {
            while (true){
                try {
//                    Thread.sleep(1000);
                    synchronized (list){
                        while (list.size()==maxCount){
                            list.wait();
                        }
                        list.add("product");
                        System.out.print("生产者" + Thread.currentThread().getId() + "生产一个物品  ");
                        System.out.println("当前数量："+list.size());
                        list.notifyAll();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class Consumer implements Runnable{

        @Override
        public void run() {
            while (true){
                try {
//                    Thread.sleep(1000);
                    synchronized (list){
                        while (list.size()==0){
                            list.wait();
                        }
                        list.poll();
                        System.out.print("消费者" + Thread.currentThread().getId() + "消费一个物品  ");
                        System.out.println("当前数量："+list.size());
                        list.notifyAll();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
       new MyDemo1().start();

    }

    private void start() {
        new Thread(new Product()).start();
        new Thread(new Consumer()).start();
    }


}
