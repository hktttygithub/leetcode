package hkttty.leetcode;

public class No523 {
    /*
    * 给定一个包含非负数的数组和一个目标整数 k，编写一个函数来判断该数组是否含有连续的子数组，其大小至少为 2，
    * 总和为 k 的倍数，即总和为 n*k，其中 n 也是一个整数。

    * */

    public boolean checkSubarraySum(int[] nums, int k) {
        return go(nums,k,0,0);
    }

    boolean go(int[] nums,int k,int index,int sum){
        if(sum%k==0){
            return true;
        }

        for(int i=index;i<nums.length;i++){
            boolean go = go(nums, k, i+1, sum + nums[i]);
            if(go){
                return true;
            }
        }
        return false;
    }
}
