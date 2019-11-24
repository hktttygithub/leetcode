package hkttty.niuke.youzan;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    /*
    * 例1：
输入数组a[5] = [1,2,3,2,5];从第一个元素开始a[0]=1,下次向后移动1位到
第二个元素a[1]=2,再次向后移动2位到第四个元素a[3],因为下次向后移动2位(a[3]=2
)后,向后数组越界,即跳出数组,输出true;
例2：
输入数组a[2] = [1,-3];从第一个元素开始a[0]=1,下次移动
1位到第二个元素a[1]=-3,再次向前移动3位后,向前数组越界,即跳出数组,输出true;
    * */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        String str = new String(sc.nextLine());
        String substring = str.substring(1, str.length() - 1);

        String[] s = substring.split(",");

        for (int i = 0; i < s.length; i++) {
            list.add(Integer.valueOf(s[i]));
        }

        int i = 0;
        HashSet<Integer> set = new HashSet<>();
        while (i >= 0 && i < list.size()) {
            if (!set.add(i)) {
                System.out.println("false");
                break;
            }
            i = list.get(i) + i;
        }
        if (i < 0 || i >= list.size()) {
            System.out.println("true");
        }

    }
}
