package test.thread.producer;

import java.util.concurrent.LinkedBlockingQueue;

public class MyLinkedBlockingQueue {
    static LinkedBlockingQueue queue = new LinkedBlockingQueue();

    public static void main(String[] args) throws InterruptedException {
        queue.put("ddd");
    }
}
