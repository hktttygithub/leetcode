package test.collection;

import org.junit.Test;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class IteratorTest {

    @Test
    public void test1(){
        ConcurrentHashMap<String,String> map = new ConcurrentHashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put("test" + i ,""+ i);
        }

        Iterator iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
//            map.put("test","22444");
            Object next = iterator.next();
            System.out.println(next.toString());
            String remove = map.remove(next);
            System.out.println(remove);

//            map.remove(iterator.next());
//            System.out.println(iterator.next());
        }
        System.out.println(map.toString());

    }
}
