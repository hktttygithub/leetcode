package hkttty.leetcode;

import org.junit.Test;

import java.util.Arrays;

public class No322Copy {
    static int[] dp;

    public int coinChange(int[] coins, int amount) {
        dp = new int[amount + 1];
//        Arrays.fill(dp,-2);
        return coinsCount(coins, amount);
    }

    private int coinsCount(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (dp[amount] != 0) {
            return dp[amount];
        }
        int res = Integer.MAX_VALUE;
        for (int val : coins) {
            if (amount - val < 0) {
                continue;
            }
            int count = coinsCount(coins, amount - val);
            if (count == -1) {
                continue;
            }
            res = Math.min(res, count + 1);
        }
        res = (res == Integer.MAX_VALUE) ? -1 : res;
        dp[amount] = res;
        return res;
    }

    @Test
    public void test1() {
        Solution t = new Solution();
        int i = t.coinChange(new int[]{1, 2, 5}, 11);
        System.out.println(i);
    }

    class Solution {
        int[] dp;

        public int coinChange(int[] coins, int amount) {
            dp = new int[amount + 1];
            return go(coins, amount,0);

        }

        int go(int[] coins, int amount,int index) {
            if (amount == 0) {
                return 0;
            }
            if (dp[amount] != 0) {
                return dp[amount];
            }
            int res = Integer.MAX_VALUE;
            for (int i = index; i < coins.length; i++) {
                if (amount - coins[i] < 0) {
                    continue;
                }
                int count = go(coins, amount - coins[i],i);
                if (count == -1) {
                    continue;
                }
                res = Math.min(res, count + 1);
            }
            res = (res == Integer.MAX_VALUE) ? -1 : res;
            dp[amount] = res;
            return res;

        }
    }
}
