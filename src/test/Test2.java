package test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Test2 {
    private String a;//引用"a"在堆

    private static String b; //引用"b"在方法区

    Collection<Integer> method1(){
        ArrayList<Integer> list = new ArrayList();
        list.add(5);
        return list;
    }

    @Test
    public void test1(){
        Set e = new HashSet();
        Collection<Integer> integers = method1();
        if(integers instanceof HashSet){
            System.out.println("123");
        }



    }
}
