package hkttty.zuo;

public class Matrix {
    int[][] flag;
    int rows;
    int cols;
    char []str ;
    char []matrix;

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        this.rows = rows;
        this.cols = cols;
        this.str = str;
        this.matrix = matrix;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                this.flag = new int[rows][cols];
                if (str[0]== matrix[i * cols + j]) {
                    if (helper(i, j,0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    boolean helper(int i, int j,int index) {
        if (i < 0 || j < 0 || i == rows || j == cols
                || flag[i][j] == -1) {
            return false;
        }
        if(str[index] != matrix[i*cols + j]){
            return false;
        }
        if(index == str.length-1){
            return true;
        }
        flag[i][j] = -1;
        return helper(i + 1, j,index+1) ||
                helper(i - 1, j,index+1) ||
                helper(i, j + 1,index+1) ||
                helper(i, j - 1,index+1);
    }

}
