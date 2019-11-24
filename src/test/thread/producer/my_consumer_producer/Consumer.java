package test.thread.producer.my_consumer_producer;

public class Consumer implements Runnable {
    @Override
    public void run() {
        while (true) {
//            try {
//                Thread.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            synchronized (Main.lock) {
                while (Main.count == Main.size) {
                    try {
                        Main.lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Main.count++;
                System.out.println(Thread.currentThread().getName() + "生产者生成一个产品" + "目前产品数:" + Main.count);
                Main.lock.notifyAll();
            }
        }

    }
}
