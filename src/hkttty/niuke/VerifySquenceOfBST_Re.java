package hkttty.niuke;

import org.junit.Test;

public class VerifySquenceOfBST_Re {
    public boolean VerifySquenceOfBST(int[] arr) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        return helper(arr, 0, arr.length - 1);
    }

    private boolean helper(int[] arr, int start, int end) {
        if (start >= end) {
            return true;
        }
        int root = arr[end];
        int i = start;
        for (; i < end; i++) {
            if (arr[i] > root) {
                break;
            }
        }
        int j = i;
        for (; j < end; j++) {
            if (arr[j] < root) {
                return false;
            }
        }
        //判断有无左右子树
        boolean flag1 = true;
        boolean flag2 = true;
        if (i > 0) {
            //有左子树
            flag1 = helper(arr, start, i - 1);
        }
        if (i != end) {
            //有右子树
            flag2 = helper(arr, i, end-1);
        }
        return flag1 && flag2;
    }

    @Test
    public void test1() {
        int[] arr = new int[]{6,5,7,4};
        boolean b = VerifySquenceOfBST(arr);
        System.out.println(b);
    }
}
