package test.thread.producer.my_consumer_producer;

public class Producter implements Runnable {
    @Override
    public void run() {
        while (true) {
//            try {
//                Thread.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            synchronized (Main.lock) {
                while (Main.count == 0) {
                    try {
                        Main.lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Main.count--;
                System.out.println(Thread.currentThread().getName() + "消费者进行消费一件产品，目前产品:" + Main.count);
                Main.lock.notifyAll();
            }
        }

    }
}
