package hkttty.niuke;

import org.junit.Test;

import java.util.ArrayList;

public class VerifySquenceOfBST {
    int []arr;
    int length;

    public boolean VerifySquenceOfBST(int [] arr) {
        if(arr==null || arr.length==0){
            return false;
        }
        this.arr = arr;
        this.length = arr.length;
        return helper(0,arr.length-1);
    }

    boolean helper(int leftStart,int root){
        if(leftStart>=root){
            return true;
        }
        int i=leftStart;
        while(arr[i]<arr[root]){
            i++;
        }
        int leftEnd = i-1;
        int rightStart = i;
        if(rightStart==root){
            //没有右子树，只找左子树
            return helper(leftStart,leftEnd);
        }
        while(i<root){
            //右子树上所有结点都必须大于根结点
            if(arr[i]<arr[root]){
                return false;
            }
            i++;
        }
        return helper(leftStart,leftEnd) && helper(rightStart,root-1);
    }

    @Test
    public void test1(){
        int []arr = new int[]{2,3,10,13,15,12,5};
        boolean b = VerifySquenceOfBST(arr);
        System.out.println(b);
    }
}
