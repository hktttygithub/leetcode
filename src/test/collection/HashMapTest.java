package test.collection;

import org.junit.Test;

import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class HashMapTest {
    HashMap<Integer,Integer> map = new HashMap<>();
    ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
    @Test
    public void test1(){
        concurrentHashMap.put("233","sdd");
        map.put(3,3);
        map.put(8,8);
        map.put(5,5);
        map.put(6,6);
        map.put(2,2);
        map.put(7,7);
        map.put(1,1);
        map.put(4,4);
//        map.put(17,17);
        System.out.println(new Integer(1).hashCode());
        for (Integer s : map.keySet()){
            System.out.print(s + " ");
        }
    }
}
