package test.thread.producer.my_consumer_producer;

public class Main {
    public static int count=0;
    public static Double lock = new Double(0.0);
    public static int size= 50;

    public static void main(String[] args) {
        Producter producter = new Producter();
        Consumer consumer = new Consumer();
        for(int i=0;i<5;i++){
            new Thread(new Producter()).start();
            new Thread(new Consumer()).start();
        }
    }
}
