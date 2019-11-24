package hkttty.leetcode;

public class No74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length <= 0 || matrix[0].length <= 0) {
            return false;
        }
        int start = 0;
        int end = matrix.length - 1;
        int row = 0;
        while (start <= end) {
            row = (start + end) / 2;
            if (matrix[row][0] <= target && matrix[row][matrix[row].length - 1] >= target) {
                break;
            } else if (matrix[row][0] < target) {
                start = row + 1;
            } else {
                end = row - 1;
            }
        }
        if (end < start) {
            return false;
        }
        start = 0;
        end = matrix[row].length - 1;
        while (start <= end) {
            int col = (start + end) / 2;
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                end = col - 1;
            } else {
                start = col + 1;
            }
        }
        return false;


    }

}
