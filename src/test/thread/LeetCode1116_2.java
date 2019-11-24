/*
class ZeroEvenOdd {
    private int n;
    int i;

    private volatile int flag = 0;

    public ZeroEvenOdd(int n) {
        this.n = n;
        this.i = 2 * n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        while (i <= n) {
            synchronized (this) {
                while (flag != 0) {
                    this.wait();
                }
                printNumber.accept(0);
                zeroState = true;
                if (i % 2 == 0) {
                    flag = 2;
                } else {
                    flag = 1;
                }
                this.notifyAll();
                i++;
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            synchronized (this) {
                while (flag != 2) {
                    this.wait();
                }
                flag = 0;
                this.notifyAll();
            }

        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            synchronized (this) {
                while (flag != 1) {
                    this.wait();
                }
                flag = 0;
                this.notifyAll();
            }

        }
    }

}*/
