package hkttty.niuke.youzan;

import java.util.Scanner;

public class No2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String substring = str.substring(1, str.length() - 1);
        String[] split = substring.split(",");
        int []arr = new int[split.length];
        for (int i=0;i<arr.length;i++){
            arr[i] = Integer.valueOf(split[i]);
        }
//        parttion(arr,0,arr.length-1);
    }


}
