package test.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Demo2 {


    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
//        Class appleClass = Class.forName("test.reflect.Apple");
        /*Apple a = (Apple)appleClass.newInstance();
        System.out.println(a.price);*/
        Class<Apple> appleClass = Apple.class;
        Constructor constructor = appleClass.getConstructor(String.class);
//        appleClass.getDeclare
        Apple abc = (Apple)constructor.newInstance("abc");
//        Field[] fields = appleClass.getFields();
//        for(Field f : fields){
//            System.out.println(f.getName());
//        }
//        Field[] declaredFields = appleClass.getDeclaredFields();
//        for(Field f : declaredFields){
//            System.out.println(f.getName());
//        }
        Method doSomeThing =
                appleClass.getDeclaredMethod("doSomeThing", String.class);
        doSomeThing.invoke(abc,"aaa");

    }
}
