package hkttty.niuke;

import java.util.ArrayList;

//题目描述
//输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字
// ，例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
// 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
public class JuZhenPrint {
    ArrayList<Integer> list = new ArrayList<>();
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        if(matrix==null || matrix.length<=0 || matrix[0].length<=0){
            return list;
        }
        int row = matrix.length-1;
        int col = matrix[0].length-1;
        int i = 0,j=0;
        while (i<=row && j<=col){
            helper(matrix,i++,j++,row--,col--);
        }
        return list;
    }

    private void helper(int[][] matrix, int startRow, int startCol, int row, int col) {
        int i = startRow;
        int j = startCol;
        if(startRow==row){
            while (j<=col){
                list.add(matrix[startRow][j++]);
            }
            return;
        }
        if(startCol==col){
            while (i<=row){
                list.add(matrix[i++][startCol]);
            }
            return;
        }
        while (j<col){
            list.add(matrix[i][j++]);
        }
        while (i<row){
            list.add(matrix[i++][j]);
        }
        while (j>startCol){
            list.add(matrix[i][j--]);
        }
        while (i>startRow){
            list.add(matrix[i--][j]);
        }
    }
}
