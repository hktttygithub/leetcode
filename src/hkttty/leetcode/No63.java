package hkttty.leetcode;

import org.junit.Test;

public class No63 {
    @Test
    public void test1(){
        int [][]arr = {{0,0,0},{0,1,0},{0,0,0}};
        int i = uniquePathsWithObstacles(arr);
        System.out.println(i);
    }

    int row;
    int col;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null ||
                obstacleGrid.length == 0 ||
                obstacleGrid[0].length == 0) {
            return 0;
        }
        row = obstacleGrid.length - 1;
        col = obstacleGrid[0].length - 1;
        if (obstacleGrid[row][col] == 1) {
            return 0;
        }
        int[][] dp = new int[row + 1][col + 1];

        boolean flag = true;
        for (int i = row; i >= 0; i--) {
            if (flag) {
                dp[i][col] = obstacleGrid[i][col] == 1 ? 0 : 1;
                flag = false;
            } else {
                dp[i][col] = 0;
            }

        }
        flag = true;
        for (int j = col; j >= 0; j--) {
            if (flag) {
                dp[row][j] = obstacleGrid[row][j] == 1 ? 0 : 1;
                flag = false;
            } else {
                dp[row][j] = 0;
            }
        }
        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
                }
            }
        }
        return dp[0][0];

    }

}
