/*
package hkttty.leetcode;

import java.util.concurrent.Semaphore;

public class No1116 {
    static class ZeroEvenOdd {
        volatile int n;
        volatile int flag = 0;

        public ZeroEvenOdd(int n) {
            this.n = n;
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void zero() throws InterruptedException {
            boolean odd = false;
            int count = 0;
            synchronized (this) {

                while (count++ < n) {
                    odd = !odd;
                    while (flag != 0) {
                        this.wait();
                    }
                    System.out.println(0);
                    if (odd) {
                        flag = 1;
                    } else {
                        flag = 2;
                    }
                    notifyAll();
                }
            }
        }

        public void even() throws InterruptedException {
            int number = 2;
            synchronized (this) {
                while (number <= n) {
                    number += 2;
                    while (flag != 2) {
                        this.wait();
                    }
                    System.out.println(number);
                    flag = 0;
                    notifyAll();
                }
            }
        }

        public void odd() throws InterruptedException {
            int number = 1;
            synchronized (this) {
                while (number <= n) {
                    number += 2;
                    while (flag != 1) {
                        this.wait();
                    }
                    System.out.println(number);
                    flag = 0;
                    notifyAll();
                }
            }
        }
    }

    public static void main(String[] args) {
        ZeroEvenOdd z = new ZeroEvenOdd(10);
        new Thread()
    }
}
*/
