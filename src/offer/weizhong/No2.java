package offer.weizhong;

import java.math.BigInteger;
import java.util.Scanner;

public class No2 {
    //求询问次数
    //题目描述：
    //Alice现在有一个数x，在范围[0,2n)内。你需要询问Alice一些问题。
    // 每次询问有一个数t，Alice会回答你 t&x 是否等于t
    // 。你不能根据已有的回答改变接下来的询问（即询问需要提前想好）。
    // 你需要最少询问多少次来保证你能确定x的值。输出答案mod106+3
    //&的意思是位与运算
    //当且仅当两种方案中有一个询问不同，我们就认为两种方法是不同的。
    // 例如询问[1,2]和[1,3]是不同的，[1,2][2,1]也是不同的（尽管他们得到了相同的结果）
    //输入
    //一个正整数n ( n≤10^9 )
    //输出
    //一个数，答案mod106+3（即对1000003取模 ）
    //样例输入
    //3
    //样例输出
    //6
    //提示
    //询问的t为1,2,4三个数，有6种排列方式（[1,2,4][1,4,2][2,1,4][2,4,1][4,1,2][4,2,1]）

    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        BigInteger go = go(n);
        System.out.println(go);
    }

    private static BigInteger go(long n) {
        BigInteger sum = new BigInteger("1");
        for(int i =1;i<=n;i++){
            sum = sum.multiply(new BigInteger(String.valueOf(i)));
        }
        return sum.mod(new BigInteger("1000003"));
    }
}
