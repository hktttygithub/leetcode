package hkttty.leetcode;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class No1114_Condition {
    class Foo{
        Lock lock = new ReentrantLock();
        Condition two = lock.newCondition();
        Condition three = lock.newCondition();
        volatile int flag =1;

        public Foo() {

        }

        public void first(Runnable printFirst) throws InterruptedException {
            lock.lock();
            printFirst.run();
            flag = 2;
            two.signal();
            lock.unlock();
            // printFirst.run() outputs "first". Do not change or remove this line.

        }

        public void second(Runnable printSecond) throws InterruptedException {
            lock.lock();
            while (flag!=2){
                two.await();
            }
            printSecond.run();
            flag = 3;
            three.signal();
            lock.unlock();
            // printSecond.run() outputs "second". Do not change or remove this line.

        }

        public void third(Runnable printThird) throws InterruptedException {
            lock.lock();
            while (flag!=3){
                three.await();
            }
            printThird.run();
            lock.unlock();
        }

    }
}
