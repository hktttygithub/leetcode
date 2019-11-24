package offer.wangyi;

import java.math.BigInteger;
import java.util.Scanner;

public class No1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        if(a<=0 || b<=0){
            System.out.println("0 0");
            return;
        }
        int max = getMax(a, b);
        String min = getMin(a, b,max);
        System.out.println(max + " " + min);
    }

    static int getMax(int p, int q) {
        while (q != 0) {
            int number = p % q;
            p = q;
            q = number;
        }
        return p;
    }

    static String getMin(int p,int q,int max){
        BigInteger p1 = new BigInteger(String.valueOf(p));
        BigInteger p2 = new BigInteger(String.valueOf(q));
        BigInteger maxB = new BigInteger(String.valueOf(max));
        return p1.multiply(p2).divide(maxB).toString();
    }
}
