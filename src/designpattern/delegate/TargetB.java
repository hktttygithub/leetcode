package designpattern.delegate;

public class TargetB implements Target {
    public void doing(String command) {
        System.out.println("我是员工A，我现在开始干" + command + "工作");
    }
}