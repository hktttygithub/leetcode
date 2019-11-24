package hkttty.leetcode;

import org.junit.Test;

import java.util.Arrays;

public class No91 {
    int []dp;
    public int numDecodings(String s) {
        char[] arr = s.toCharArray();
        dp = new int[arr.length];
        Arrays.fill(dp,-1);
        return find(arr,0);
    }

    private int find(char[] arr, int index) {
        if(index==arr.length){
            return 1;
        }
        if(dp[index]!=-1){
            return dp[index];
        }
        int cache = 0;
        if(arr[index]=='0'){
            return 0;
        }else{
            if(index+1==arr.length){
                return 1;
            }
            if(arr[index]=='1' || (arr[index]=='2' && (arr[index+1] >='0' && arr[index+1]<='6'))){
                cache = find(arr,index+1) + find(arr,index+2);
            }else{
                cache =  find(arr,index+1);
            }
            dp[index] = cache;
            return cache;
        }
    }

    @Test
    public void test1(){
        int i = numDecodings("226");
        System.out.println(i);
    }
}
