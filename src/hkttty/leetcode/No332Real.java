package hkttty.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;

public class No332Real {


    @Test
    public void test1() {
        int[] coins = {357,239,73,52};
        int aim = 9832;//35
        int i = coinChange(coins, aim);
        System.out.println(i);
    }


    int min = Integer.MAX_VALUE;
    int []arr;
//    HashMap<String,Integer> map = new HashMap<>();
    int [][] map;

    public int coinChange(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim <= 0) {
            return 0;
        }
        map = new int[arr.length+1][aim+1];
        this.arr = arr;
        process2(0, aim, 0);
        return min==Integer.MAX_VALUE ? -1 : min;
    }

    public void process2( int index, int aim, int count) {
        if (index == arr.length) {
            if (aim == 0 && count < min) {
                min = count;
            }
            return;
        } else {
            int mapCount = 0;
            for (int i = 0; arr[index] * i <= aim; i++,count++) {
                mapCount = map[index + 1][aim - arr[index] * i];
                if(mapCount==0){
                    process2(index + 1, aim - arr[index] * i, count);
                    map[index + 1][aim - arr[index] * i] = count;
                }

//                String key = String.valueOf(index+1) + "_" + String.valueOf(aim - arr[index] * i);
//                if (!map.containsKey(key) || map.get(key)>count) {
//                    process2(index + 1, aim - arr[index] * i, count);
//                    map.put(key,count);
//                }else{
//                    System.out.println(key);
//                    break;
//                }
            }
        }
        return;
    }
}
