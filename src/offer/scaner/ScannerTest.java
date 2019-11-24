package offer.scaner;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> list1 = new ArrayList<Integer>();
        String s = null;
        while (!(s = sc.nextLine()).equals("")) {
            String[] str = s.split(",");
            for (int i = 0; i < str.length; i++) {
                list1.add(Integer.parseInt(str[i]));
            }
            list.add(list1);
        }
        System.out.println(list);
    }

    @Test
    public void test1(){
        Scanner in = new Scanner(System.in);
        System.out.println("shuru");
        while (in.hasNextInt()) {//注意while处理多个case
            int b = in.nextInt();
            int a = in.nextInt();
            System.out.println(a + b);
        }
    }
}
