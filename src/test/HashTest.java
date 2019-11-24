package test;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;

public class HashTest {
    @Test
    public void test1(){
        HashMap<String,Integer> map = new HashMap<>();
        System.out.println("Aa".hashCode());
        System.out.println("BB".hashCode());
        map.put("Aa",1);
        map.put("BB",1);
        for(String s : map.keySet()){
            System.out.println(s);
        }
    }

    @Test
    public void test2(){
        int code = "test".hashCode();
        System.out.println(code);
    }

    @Test
    public void test3(){
        HashSet<String> s = new HashSet<>();
        s.add("asbcc");
        for (String sss : s){

        }
        for(String sss : s){
            System.out.println(sss);
        }
    }


}
