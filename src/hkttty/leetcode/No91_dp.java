package hkttty.leetcode;

public class No91_dp {
    public int numDecodings(String s) {
        if(s.length()==0){
            return 0;
        }
        char[] arr = s.toCharArray();
        if(arr[0]=='0'){
            return 0;
        }

        int []dp = new int[s.length()];
        dp[0] = 1;

        for(int i=0;i<dp.length;i++){

        }
        return -1;
    }
}
