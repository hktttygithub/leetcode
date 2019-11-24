package test.thread;

import org.junit.Test;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class HashMapTest2 {
    HashMap<Long,String> test = new HashMap(Integer.MAX_VALUE,0.75f);

    AtomicInteger integer = new AtomicInteger(10);

    @Test
    public void test1(){
        integer.incrementAndGet();

    }
}
