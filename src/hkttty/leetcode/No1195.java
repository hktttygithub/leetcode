package hkttty.leetcode;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

public class No1195 {
    class FizzBuzz {
        private int n;

        Semaphore fizzSemahore = new Semaphore(0);
        Semaphore buzzSemahore = new Semaphore(0);
        Semaphore fizzbuzzSemahore = new Semaphore(0);
        Semaphore numberSemahore = new Semaphore(0);
        volatile boolean over = false;


        public FizzBuzz(int n) {
            this.n = n;
        }

        // printFizz.run() outputs "fizz".
        public void fizz(Runnable printFizz) throws InterruptedException {
            while (true){
                fizzSemahore.acquire();
                if(over){
                    break;
                }
                printFizz.run();
                numberSemahore.release();
            }

        }

        // printBuzz.run() outputs "buzz".
        public void buzz(Runnable printBuzz) throws InterruptedException {
            while (true) {
                buzzSemahore.acquire();
                if(over){
                    break;
                }
                printBuzz.run();
                numberSemahore.release();
            }
        }

        // printFizzBuzz.run() outputs "fizzbuzz".
        public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
            while (true) {
                fizzbuzzSemahore.acquire();
                if(over){
                    break;
                }
                printFizzBuzz.run();
                numberSemahore.release();
            }
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void number(IntConsumer printNumber) throws InterruptedException {
            for(int i=1;i<=n;i++){
                boolean fizz = false;
                boolean buzz = false;
                if (i%3==0){
                    fizz = true;
                }
                if (i%5==0){
                    buzz = true;
                }
                if(buzz && fizz){
                    fizzbuzzSemahore.release();
                    numberSemahore.acquire();
                }else if(buzz){
                    buzzSemahore.release();
                    numberSemahore.acquire();
                }else if(fizz){
                    fizzSemahore.release();
                    numberSemahore.acquire();
                }else{
                    printNumber.accept(i);
                }
            }
            over = true;
            fizzbuzzSemahore.release();
            buzzSemahore.release();
            fizzSemahore.release();
        }
    }
}
