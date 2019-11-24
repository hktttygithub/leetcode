package hkttty.niuke;

import org.junit.Test;

import java.util.Scanner;

public class Test1 {
    @Test
    public void test1(){
        String str = new String();
        str.hashCode();
        str.equals("333");
        double a = Math.pow(10,9);
        double a2 = Math.pow(10,5);
        double b = Integer.MAX_VALUE;
        System.out.println(a>b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n<=0){
            return;
        }
        StringBuilder s = new StringBuilder("" + sc.nextInt()) ;
        for (int i = 1; i < n; i++) {
            s =  s.append(" " + sc.nextInt());
            s.reverse();
        }
        System.out.println(s);
    }

}
