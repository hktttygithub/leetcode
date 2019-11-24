package hkttty.leetcode;

public class No1114 {
    class Foo {
        volatile int flag = 0;

        public Foo() {

        }

        public void first(Runnable printFirst) throws InterruptedException {

            // printFirst.run() outputs "first". Do not change or remove this line.
            synchronized (this) {
                printFirst.run();
                flag = 1;
                notifyAll();
            }
        }

        public void second(Runnable printSecond) throws InterruptedException {
            synchronized (this) {
                while (flag != 1) {
                    wait();
                }
                printSecond.run();
                flag = 2;
                notifyAll();
            }
        }

        public void third(Runnable printThird) throws InterruptedException {
            synchronized (this) {
                while (flag != 2) {
                    wait();
                }
                printThird.run();
                notifyAll();
            }
            // printThird.run() outputs "third". Do not change or remove this line.

        }
    }
}
