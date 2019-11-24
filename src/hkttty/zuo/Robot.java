package hkttty.zuo;

import org.junit.Test;

public class Robot {
    int maxSum;
    int count = 0;
    int rows;
    int cols;
    int [][]flag;

    public int movingCount(int threshold, int rows, int cols) {
        if (threshold < 0 || rows < 0 || cols < 0) {
            return 0;
        }
        maxSum = threshold;
        this.rows = rows;
        this.cols = cols;
        flag = new int[rows][cols];
        helper(0, 0);
        return count;
    }

    void helper(int curRow, int curCol) {
        if ( curRow == rows || curRow < 0 || curCol == cols || curCol < 0 || flag[curRow][curCol]==-1) {
            return;
        }
        int sum = 0;
        int helpR = curRow;
        while (helpR != 0) {
            sum += helpR % 10;
            helpR = helpR / 10;
        }
        int helpC = curCol;
        while (helpC != 0) {
            sum += helpC % 10;
            helpC = helpC / 10;
        }
        if (sum > maxSum) {
            return;
        }
        count++;
        flag[curRow][curCol] = -1;

        helper(curRow + 1, curCol);
        helper(curRow - 1, curCol);
        helper(curRow, curCol + 1);
        helper(curRow, curCol - 1);
    }

    @Test
    public void test1(){
        int i = movingCount(10, 5, 5);
        System.out.println(i);
    }
}
