package hkttty.leetcode;

import org.junit.Test;

public class No53 {
    int max;
    int length;

    @Test
    public void test1(){
        //[-2,1,-3,4,-1,2,1,-5,4]
//        int [] arr = new int[]{3,-2,5,-1};
        int []arr = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int i = maxSubArray(arr);
        System.out.println(i);
    }

    public int maxSubArray(int[] nums) {
        max = nums[0];
        length = nums.length;
        for (int i = 0; i < length; i++) {
            findMax(nums, i, 0);
        }
        return max;
    }

    void findMax(int[] nums, int i, int sum) {
        if (i == length) {
            return;
        }
        if (sum + nums[i] > max)
            max = sum + nums[i];
        findMax(nums, i + 1, sum + nums[i]);

    }

}
