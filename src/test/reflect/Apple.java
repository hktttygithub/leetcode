package test.reflect;

public class Apple {
    public int price = 5;
    private String name;

    public Apple() {

    }

    public Apple(String abc) {
        System.out.println("苹果" + abc);
    }

    private void doSomeThing(String sss){
        System.out.println(sss);
    }

}
