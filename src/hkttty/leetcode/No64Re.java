package hkttty.leetcode;

import org.junit.Test;

public class No64Re {
    int row;
    int col;

    /*
    * [[1,2],[5,6],[1,1]]
    * */
    @Test
    public void  test1(){
        int [][]arr = {{1,2},{5,6},{1,1}};
        int i = dp(arr);
        System.out.println(i);
    }

    public int minPathSum(int[][] grid) {
        if(grid==null || grid.length<=0 || grid[0].length<=0){
            return 0;
        }
        row = grid.length;
        col = grid[0].length;
        return helper(grid,0,0);
    }

    private int helper(int[][] arr,int i,int j) {
        if(i==row-1 && j==col-1){
            return arr[i][j];
        }
        int sum = 0;
        if(i==row-1){
            sum += arr[i][j] + helper(arr,i,j+1);
        }else if(j==col-1){
            sum += arr[i][j] + helper(arr,i+1,j);
        }else{
            sum += arr[i][j] + Math.min(helper(arr,i,j+1), helper(arr,i+1,j));
        }
        return  sum;
    }

    int dp(int [][]arr){
        if(arr==null || arr.length<=0 || arr[0].length<=0){
            return 0;
        }
        int row = arr.length-1;
        int col = arr[0].length-1;
        int [][]dp = new int[row+1][col+1];
        dp[row][col] = arr[row][col];
        for(int j=col-1;j>=0;j--){
            dp[row][j] = arr[row][j] + dp[row][j+1];
        }
        for(int i=row-1;i>=0;i--){
            dp[i][col]  = arr[i][col] + dp[i+1][col];
        }
        for(int i=row-1;i>=0;i--){
            for(int j=col-1;j>=0;j--){
                dp[i][j] = arr[i][j] + Math.min(dp[i][j+1],dp[i+1][j]);
            }
        }
        return dp[0][0];
    }
}
