package hkttty.zuo;

import org.junit.Test;

import java.util.HashMap;

//动态规划：背包问题
public class Bag {
    int[] w;
    int[] v;
    int bigWeight;

    int findMax(int[] w, int[] v, int bigWeight) {
        if (w == null || v == null || w.length <= 0 || w.length != v.length || bigWeight <= 0) {
            return 0;
        }
        this.w = w;
        this.v = v;
        this.bigWeight = bigWeight;
        int max = helper(0,  0);

        return max;
    }

    private int helper(int sumWeight, int index) {
        if( sumWeight > bigWeight){
            return Integer.MIN_VALUE;
        }
        if (index == w.length) {
            return 0;
        }
        int v1 = helper(sumWeight,  index + 1);
        int v2 = v[index] + helper(sumWeight + w[index], index + 1);
        return Math.max(v1, v2);
    }

    int dp(int[] w, int[] v, int bigWeight) {
        if (w == null || v == null || w.length <= 0 || w.length != v.length || bigWeight <= 0) {
            return 0;
        }
        int dp[][] = new int[w.length + 1][bigWeight+1];
        for(int j=0;j<=bigWeight;j++){
            dp[w.length][j] = 0;
        }
        /*
        int v1 = helper(sumWeight,  index + 1);
        int v2 = v[index] + helper(sumWeight + w[index], index + 1);
        */
        for (int i = w.length-1; i >=0 ; i--) {
            for(int j=bigWeight;j>=0;j--){
                int v1 = dp[i+1][j];
                int v2 = 0;
                if(j+w[i]<=bigWeight){
                    v2 = dp[i+1][j+w[i]] + v[i];
                }
                dp[i][j] = Math.max(v1,v2);
            }
        }
        return dp[0][0];
    }

    @Test
    public void test1() {
        //33 25
        int[] w = {3, 2, 4, 7};
        int[] v = {5, 6, 3, 19};
        int bag = 11;
        System.out.println(dp(w, v, bag));
    }
}
