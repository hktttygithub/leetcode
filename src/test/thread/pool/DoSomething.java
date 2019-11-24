package test.thread.pool;

public class DoSomething implements Runnable{
    int a;
    static  Integer flag = 1;

    public void setA(int a) {
        this.a = a;
    }

    @Override
    public void run() {
//        System.out.println(this);
        while (true){
            System.out.println(Thread.currentThread().getName() + "-----------a=" + a);
            if(flag==1){
                Thread.yield();
//                synchronized (flag){
//                    if(flag==1){
                        flag=2;
                        a=-1000;
//                    }
//                }
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
