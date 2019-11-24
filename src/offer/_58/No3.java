package offer._58;

import java.util.Arrays;
import java.util.Scanner;

public class No3 {
    static int [][]arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        arr = new int[m][n];
        for(int i = 0;i<m;i++){
            for(int j=0;j<n;j++){
                arr[i][j] = sc.nextInt();
            }
        }
        int go = go(arr);
        System.out.println(go);
    }

    private static int go(int[][] arr) {
        int row = arr.length-1;
        int col = arr[0].length -1;
        int [][]dp = new int[row+1][col+1];
        dp[row][col] = arr[row][col];
        for(int j=col-1;j>=0;j--){
            dp[row][j] = arr[row][j] + dp[row][j+1];
        }
        for(int i=row-1;i>=0;i--){
            dp[i][col] = arr[i][col] + dp[i+1][col];
        }
        for(int i=row-1;i>=0;i--){
            for(int j=col-1;j>=0;j--){
                dp[i][j] = arr[i][j] + Math.min(dp[i][j+1],dp[i+1][j]);
            }
        }
        return dp[0][0];
    }
}
