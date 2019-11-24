package hkttty.leetcode;

import org.junit.Test;

public class No122 {
    /*public int maxProfit(int[] prices) {
        if(prices==null || prices.length<2){
            return 0;
        }
        int [][][]dp = new int[prices.length][prices.length/2][2];
        for(int k=0;k<prices.length/2;k++){
            dp[0][k][0] = 0;
            dp[0][k][1] = Integer.MIN_VALUE;
        }

        for(int i=1;i<prices.length;i++){
            for(int k=0;k<prices.length/2;k++){
                dp[i][k][0] = Math.max(dp[i-1][k][0],dp[i-1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i-1][k-1][1],dp[i-1][k-1][0]-prices[i]);
            }
        }
        return dp[prices.length-1][prices.length/2-1][0];
    }*/

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
            dp[i][1] = Math.max(dp[i - 1][1], dp[i-1][0]- prices[i - 1]);
        }
        return dp[prices.length][0];
    }


    /*
    * 输入: [7,1,5,3,6,4]
输出: 7
    * */
    @Test
    public void test1(){
        int []arr ={7,1,5,3,6,4};
        int i = maxProfit(arr);
        System.out.println(i);
    }
}
