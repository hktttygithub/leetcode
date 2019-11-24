package designpattern.delegate;

public class TargetA implements Target {
    public void doing(String command) {
        System.out.println("我是员工B，我现在开始干" + command + "工作");
    }
}