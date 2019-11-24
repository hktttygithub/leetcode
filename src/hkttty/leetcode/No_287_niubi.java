package hkttty.leetcode;

import org.junit.Test;

public class No_287_niubi {
    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]);
            if (nums[index] < 0) return index;
            nums[index] = -nums[index]; // 取反表示已访问
        }
        return -1;
    }

    @Test
    public void test1() {
        int []arr = new int[]{1,2,3,4,4};
        System.out.println(findDuplicate(arr));
    }


}
