package hkttty.leetcode;

import org.junit.Test;

public class No64 {

    int row;
    int col;

    @Test
    public void test1(){
        int [][]arr = {{1,3,1},{1,5,1},{4,2,1}};
        int i = minPathSum(arr);
        System.out.println(i);
    }

    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        row = grid.length;
        col = grid[0].length;
        int[][] dp = new int[row][col];
        dp[row - 1][col - 1] = grid[row - 1][col - 1];
        for (int i = row - 2; i >= 0; i--) {
            dp[i][col - 1] = grid[i][col - 1] + dp[i + 1][col - 1];
        }
        for (int j = col - 2; j >= 0; j--) {
            dp[row - 1][j] = grid[row - 1][j] + dp[row - 1][j + 1];
        }
        for (int i = row - 2; i >= 0; i--) {
            for (int j = col - 2; j >= 0; j--) {
                dp[i][j] = grid[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
            }
        }
        return dp[0][0];
    }


}
