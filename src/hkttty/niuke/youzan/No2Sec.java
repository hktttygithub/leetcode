package hkttty.niuke.youzan;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class No2Sec {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String substring = str.substring(1, str.length() - 1);
        String[] split = substring.split(",");
        int []arr = new int[split.length];
        if(arr.length==1){
            System.out.println(split[0]);
            return;
        }

        HashMap<String,Integer> map = new HashMap<>();
        for (int i=0;i<arr.length;i++){
            if(map.containsKey(split[i])){
                int count = map.get(split[i]) + 1;
                map.put(split[i],count);
                if(count>=arr.length/2){
                    System.out.println(split[i]);
                    return;
                }
            }else {
                map.put(split[i], 1);
            }
        }

    }
}
