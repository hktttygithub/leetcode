package hkttty.leetcode;

import org.junit.Test;

import java.util.Arrays;

public class No518 {
    /*
     * 给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。
     * */
    int[] dp;

    public int change(int amount, int[] coins) {
        dp = new int[amount + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = -1;
        }
        return go(amount, coins);
    }

    private int go(int amount, int[] coins) {
        if (amount == 0) {
            return 1;
        }
        if (dp[amount] != -1) {
            return dp[amount];
        }
        int count = 0;
        for (int i = 0; i < coins.length; i++) {
            if (amount - coins[i] < 0) {
                continue;
            }
            count += go(amount - coins[i], coins);
        }
        dp[amount] = count;
        return count;
    }

    @Test
    public void test1() {
        /*输入: amount = 5, coins = [1, 2, 5]*/
        int change = change(5, new int[]{1, 2, 5});
        System.out.println(change);
    }
}
