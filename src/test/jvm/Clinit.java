package test.jvm;

public class Clinit {

    public static void main(String[] args) throws InterruptedException {
        new Thread(()->start()).start();
        new Thread(()->start()).start();
        Thread.sleep(5000);
    }

    static void start(){
        System.out.println(Thread.currentThread() + "start");
        System.out.println(ABC.a);
        System.out.println(Thread.currentThread() + "over");
    }

    static class ABC{
        static  int a = 10;
        static {
            if(true){
                System.out.println("init");
                while (true){

                }
            }
        }

    }
}
