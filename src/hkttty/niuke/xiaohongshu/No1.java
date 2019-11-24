package hkttty.niuke.xiaohongshu;

import java.util.HashMap;
import java.util.Scanner;

public class No1 {
    static HashMap<Integer,Integer> map = new HashMap<>();

    public static void main(String[] args) {
        int n;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        if(n==0){
            System.out.println(0);
            return;
        }
        map.put(1,1);
        map.put(10,1);
        int sum = 0;
        for (int i = 1; i <=n; i++) {
            sum +=check(i);
        }
        System.out.println(sum);
    }

    static int check(int number){
        int old = number;
        int count = 0;
        //第一次
        count = (number%10==1) ? 1: 0;

        number = number /10;
        if(number==0){
            return count;
        }

        if(map.get(number)==null){
            map.put(old,count);
            return count;
        }else{
            count += map.get(number);
            map.put(old,count);
            return count;
        }
    }
}
