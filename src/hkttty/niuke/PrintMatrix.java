package hkttty.niuke;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class PrintMatrix {
    ArrayList<Integer> list = new ArrayList<Integer>();

    @Test
    public void test1(){
        int [][]arr = new int[2][2];
        arr[0][0]=1;
        arr[0][1]=2;
        arr[1][0]=3;
        arr[1][1]=4;
        ArrayList<Integer> list = printMatrix(arr);
        System.out.println(list.toString());
    }

    
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0){
            return null;
        }
        int row = matrix.length-1;
        int col = matrix[0].length-1;
        int i =0,j=0;
        while (i<=row && j<=col){
            helper(matrix,i++,j++,row--,col--);
        }
        return list;
    }


    void helper(int [][]matrix,int startR,int startC,int row,int col){
        int i = startR;
        int j = startC;
        if(startR==row){
            while(j<=col){
                list.add(matrix[i][j++]);
            }
            return;
        }
        if(startC==col){
            while(i<=row){
                list.add(matrix[i++][j]);
            }
            return;
        }
        while(j<col){
            list.add(matrix[i][j++]);
        }
        while(i<row){
            list.add(matrix[i++][j]);
        }
        while(j>startC){
            list.add(matrix[i][j--]);
        }
        while(i>startR){
            list.add(matrix[i--][j]);
        }
    }

}