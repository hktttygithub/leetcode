package offer._58;

import java.util.HashMap;
import java.util.Scanner;

public class No1 {
    static HashMap<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.split(",");
        for (String val : split){
            Integer i = Integer.valueOf(val);
            map.put(i,1);
        }
        System.out.println(map.size());
    }
}
