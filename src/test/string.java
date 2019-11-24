package test;

import org.junit.Test;

public class string {

    @Test
    public void strTest(){
        String fir = "abc";
        String sec = new String("abc");
        String third = "a" + "b" + "c";
        String f = new String("ab") + "c";
        System.out.println(fir==sec);
        System.out.println(third==sec);
        System.out.println(fir==third);
        System.out.println(fir==f);
    }
}
