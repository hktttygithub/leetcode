package test.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Demo1 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<String> stringClass = String.class;

        Method hashCodeMethod = stringClass.getDeclaredMethod("hashCode");

        String str= "hello, world";
        Object hashCode= hashCodeMethod.invoke(str);
        System.out.println( hashCode);
    }
}
