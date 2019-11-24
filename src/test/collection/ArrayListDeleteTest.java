package test.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListDeleteTest {




    @Test
    public void test1() {
        List<String> a = new ArrayList<>();
        a.add("1");
        a.add("2");
        a.add("3");
        Iterator<String> it = a.iterator();
        while (it.hasNext()) {
            String temp = it.next();
            System.out.println("temp: " + temp);
        }
        System.out.println(a);
    }
}
