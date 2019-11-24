package offer.kuaishou;

import java.util.Arrays;

public class No4_Re {
    private static int find(int[] arr) {
        Arrays.sort(arr);
        int len = arr[arr.length - 1] - arr[0];
        int[][] dp = new int[arr.length][len + 1];
        for (int i = 0; i < dp.length; i++) {
            for(int j=0;j<dp[0].length;j++){
                dp[i][j] = 1;
            }
        }
        int res = 0;
        for(int i =1;i< dp.length;i++){
            for(int j=0;i<i;j++){
                int d = arr[i] - arr[j];
                dp[i][d] = Math.max(dp[i][d],dp[j][d] + 1);
                res = Math.max(dp[i][d],res);
            }
        }
        return res;
    }

}
