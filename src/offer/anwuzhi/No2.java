package offer.anwuzhi;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class No2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] split = str.split(",");
        go(split);

        //请在这里输入你的代码
        System.out.println(Arrays.toString(split));
//        ArrayList;
    }

    private static void go(String[] split) {
        Arrays.sort(split);
    }
}
