package offer.bilibili;

import java.util.Scanner;

public class No3 {
    /*
    *
     * 3
a 3
b 8
c 9
    * */
    static int count = 0;

    //s1 个数之间的分割
    //s2 key分隔符
    static void go(String s1, String s2, String s3) {
        StringBuffer key = new StringBuffer("");
        String[] split = s3.split(s1);
        count = split.length;
//        boolean isKey = true;
//        for (int i = 0; i < s3.length(); i++) {
//            if (isKey) {
//                char c = s3.
//            }
//        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        String s3 = sc.nextLine();
        go(s1, s2, s3);
        System.out.println(count);
//        System.out.println(s1 + "..." + s2+ "..." + s3);
    }
}
