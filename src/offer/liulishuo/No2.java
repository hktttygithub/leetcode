package offer.liulishuo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class No2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> arrayList = new ArrayList<>();
        while (sc.hasNext()){
            arrayList.add(sc.next());//nextLine()/next()看情况使用
        }
        System.out.println(arrayList.toString());
    }
}
