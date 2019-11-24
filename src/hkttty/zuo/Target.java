package hkttty.zuo;

import org.junit.Test;

public class Target {
    @Test
    public void test1(){
        int[] arr = { 1, 4, 8 };
        int aim = 12;
        boolean b = find(arr, aim);
        boolean b2 = dp(arr, aim);
        System.out.println(b + "   " + b2);
    }

    boolean find(int []arr,int aim){
        if(arr==null || arr.length<=0){
            return false;
        }
        return helper(arr,0,aim);
    }

    private boolean helper(int[] arr,int index, int aim) {
        if(index==arr.length){
            return aim==0;
        }
        boolean flag1 = helper(arr,index+1 ,aim-arr[index]);
        boolean flag2 = helper(arr,index+1 ,aim);

        return  flag1 || flag2;

    }

    boolean dp(int []arr,int aim){
        if(arr==null || arr.length<=0){
            return false;
        }
        boolean dp[][] = new boolean[arr.length+1][aim+1];
        int length = arr.length;

        for(int index = length;index>=0;index--){
            dp[index][0] = true;
        }

        for(int i = length-1;i>=0;i--){
            for(int j=1;j<=aim;j++){
                dp[i][j] = dp[i+1][j] || (j-arr[i]>=0 ? dp[i+1][j-arr[i]] : false );
            }
        }
        return dp[0][aim];
    }
}
