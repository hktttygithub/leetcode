package test.jvm;

public class Java3yTest {
    /*
1、通过java.exe运行Java3yTest.class，随后被加载到JVM中，元空间存储着类的信息(包括类
的名称、方法信息、字段信息..)。
2、然后JVM找到Java3yTest的主函数入口(main)，为main函数创建栈帧，开始执行main函数
3、main函数的第一条命令是Java3y java3y = new Java3y();就是让JVM创建一个Java3y对象，
但是这时候方法区中没有Java3y类的信息，所以JVM马上加载Java3y类，把Java3y类的类型信息
放到方法区中(元空间)
4、加载完Java3y类之后，Java虚拟机做的第一件事情就是在堆区中为一个新的Java3y实例分配内存
, 然后调用构造函数初始化Java3y实例，这个Java3y实例持有着指向方法区的Java3y类的类型信息（
其中包含有方法表，java动态绑定的底层实现）的引用
5、当使用java3y.setName("Java3y");的时候，JVM根据java3y引用找到Java3y对象，然后根据Java3y
对象持有的引用定位到方法区中Java3y类的类型信息的方法表，获得setName()函数的字节码的地址
6、为setName()函数创建栈帧，开始运行setName()函数

    */

    public static void main(String[] args) {
        Java3y java3yTest = new Java3y();
        java3yTest.setName("456");
    }
}
