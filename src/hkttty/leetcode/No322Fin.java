package hkttty.leetcode;

import org.junit.Test;

public class No322Fin {
    int[] coins;
    int amount;

    public int coinChange(int[] coins, int amount) {
        if (coins == null || amount < 0) {
            return 0;
        }
        this.coins = coins;
        this.amount = amount;
        return helper(0, 0);
    }

    private int helper(int index, int sum) {
        if(sum>=amount){
            return sum==amount ?  1 : Integer.MAX_VALUE;
        }
        if (index == coins.length) {
            return sum == amount ? 0 : Integer.MAX_VALUE;
        }
        int res = Integer.MAX_VALUE;

        helper(index, sum + coins[index]);
        helper(index + 1, sum);
        return res == Integer.MAX_VALUE ? Integer.MAX_VALUE : res + 1;
    }

    @Test
    //coins = [1, 2, 5], amount = 11
    public void test1() {
        int[] arr = {1, 2, 5};
        int amount = 11;
//        int []arr = {1,2};
//        int amount =5;
        int i = coinChange(arr, amount);
        System.out.println(i);
    }

}
