package test.thread;

public class LeetCode1115 {
    public static void main(String[] args) {
        FooBar f1 = new FooBar(1);
        Thread foo = new Thread(()-> System.out.println("foo"));
        Thread bar = new Thread(()-> System.out.println("bar"));

    }

    static class FooBar {
        private int n;
        volatile boolean fooPrint;

        public FooBar(int n) {
            this.n = n;
            this.fooPrint = true;
        }

        public void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                synchronized (this) {
                    while (!fooPrint) {
                        try {
                            this.wait();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    printFoo.run();
                    fooPrint = false;
                    this.notify();
                    this.wait();
                }
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                synchronized (this) {
                    while (fooPrint) {
                        try {
                            this.wait();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    printBar.run();
                    fooPrint = true;
                    this.notify();
                    this.wait();
                }
            }
        }
    }
}
