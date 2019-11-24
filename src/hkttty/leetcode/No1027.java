package hkttty.leetcode;

import java.util.Arrays;

public class No1027 {
    //给定一个整数数组 A，返回 A 中最长等差子序列的长度。
    //回想一下，A 的子序列是列表 A[i_1], A[i_2], ..., A[i_k] 其中
    //  0 <= i_1 < i_2 < ... < i_k <= A.length - 1。
    // 并且如果 B[i+1] - B[i]( 0 <= i < B.length - 1) 的值都相同，那么序列 B 是等差的。

    public int longestArithSeqLength(int[] arr) {
        if(arr==null || arr.length<=0){
            return 0;
        }
        Arrays.sort(arr);
        int res = 0;
        int [][]dp = new int[arr.length][arr[arr.length-1-arr[0]]+1];
        for(int i =1;i<dp.length;i++){
            for(int j=0;j<i;j++){
                int d = arr[i] - arr[j];
//                dp[i][d] = dp[i]
            }
        }
        return -1; //wait
    }
}
