package test.str;

import org.junit.Test;

public class StringPool {
    @Test
    public void test1(){
//        String s1 = new String("计算机");
//        String s2 = s1.intern();
        String s3 = "计算机";
        String s4 = s3.intern();
//        System.out.println(s2);
//        System.out.println(s1==s2);
//        System.out.println(s3==s2);
        System.out.println(s3==s4);
        String s5 = new String("abc");
        String s6 = "abc";
        System.out.println(s5==s6);
    }
}
