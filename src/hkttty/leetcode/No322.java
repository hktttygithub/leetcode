package hkttty.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class No322 {


    @Test
    public void test1() {
        int[] coins = {1,2,5};
        int aim = 11;
        int i = coinChange(coins, aim);
        System.out.println(i);
    }


    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length <= 0 || amount <= 0) {
            return 0;
        }
        int value = helper(coins, 0, amount, 0);
        return value==Integer.MAX_VALUE ? -1 : value;
    }

    int dp(int[]arr,int index,int aim,int sumCount){

        return 0;
    }

    int helper(int[] arr, int index, int aim, int sumCount) {
        if (index == arr.length) {
            if (aim == 0) {
                return sumCount;
            } else {
                return Integer.MAX_VALUE;
            }
        }
        int minSum = Integer.MAX_VALUE;
        for (int i = 0; aim >= 0; ) {
            minSum = Math.min(helper(arr, index + 1, aim, sumCount), minSum);
            i++;
            aim = aim - arr[index];
            sumCount++;
        }
        return minSum;
    }



}
