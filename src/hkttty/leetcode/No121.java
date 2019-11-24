package hkttty.leetcode;

import org.junit.Test;

public class No121 {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int[][] dp = new int[prices.length + 1][2];
        //0 : 未持有
        //1 :　持有
        dp[0][0] = 0;
        dp[0][1] = Integer.MIN_VALUE;
        for (int i = 1; i <= prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i - 1]);
            dp[i][1] = Math.max(dp[i - 1][1], 0- prices[i - 1]);
        }
        return dp[prices.length][0];
    }

    @Test
    public void test1() {
        /*
[7,1,5,3,6,4]*/
        int[] arr = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(arr));
    }
}
