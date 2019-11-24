/*
package test.thread.cas;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//版本号实现cas
public class CASVersion {
    volatile AtomicInteger version = new AtomicInteger(0); //版本号
    volatile int count = 100; //多个线程共享的变量
    Lock lock = new ReentrantLock();

    void add() {
        do {
            int c = this.count; // 获取当前值
            compareAndSwap(c, version);
        } while (true);
    }

    boolean compareAndSwap(int c, AtomicInteger ver) {
        lock.lock();
        try {
            if (version.get() == ver.get()) {
                c = c + 100;
                ver.incrementAndGet();
            }
        } finally {
            lock.unlock();
        }
    }
}
*/
