package test;

import javafx.util.Pair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Test {
    private Map<Pair<Integer, Integer>, Integer> map = new HashMap<>();

    static ThreadLocal<String> s = new ThreadLocal<>();

    {
        System.out.println("test");
    }


    @org.junit.Test
    public void test1(){
        Integer i = new Integer(10);
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(5);
        test3(list1);
        System.out.print("list1是否为null:");
        System.out.println(list1==null);

    }

    void test3(ArrayList list3){
        list3=null;
    }

    void test2(ArrayList list2){
        list2.add(5);
    }



    void removeList(ArrayList<Integer> list1){
        list1.remove(list1.size()-1);
        list1.remove(list1.size()-1);
    }


    @org.junit.Test
    public void test3(){
    }
}


