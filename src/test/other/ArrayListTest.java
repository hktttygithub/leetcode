package test.other;

import org.junit.Test;

import java.util.ArrayList;

public class ArrayListTest {

    @Test
    public void  test1(){
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<ArrayList<Integer>> list2 = new ArrayList<>();
        list1.add(2);
        list1.add(5);
        list2.add(list1);
        list1.remove(1);
        System.out.println(list2.toString());
    }
}
