package designpattern.delegate.single;

//静态内部类
public class SingleDemo1 {
    private static class Single {
        private static final SingleDemo1 singleDemo1 = new SingleDemo1();
    }

    public SingleDemo1 getSingle() {
        return Single.singleDemo1;
    }
}
