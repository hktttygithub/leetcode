package offer.weizhong;

import java.math.BigInteger;
import java.util.Scanner;

public class NO1 {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        char c = go(n);
        System.out.println(c);
    }

    private static char go(long n) {
        BigInteger sum = new BigInteger("1");
        for(int i =1;i<=n;i++){
            sum = sum.multiply(new BigInteger(String.valueOf(i)));
        }
        String str = String.valueOf(sum);
        for(int i =str.length()-1;i>=0;i--){
            char c = str.charAt(i);
            if(c!='0'){
                return c;
            }
        }
        return '1';
    }
}
