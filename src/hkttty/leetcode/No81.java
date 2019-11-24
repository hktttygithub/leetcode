package hkttty.leetcode;

import org.junit.Test;

public class No81 {
    //假设按照升序排序的数组在预先未知的某个点上进行了旋转。
    //( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
    //编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。
    public boolean search(int[] nums, int target) {
        if(nums==null || nums.length<=0){
            return false;
        }
        if(nums[nums.length-1] == nums[0]){
            if(nums[0]==target){
                return true;
            }else{
                for(int val : nums){
                    if(val == target){
                        return true;
                    }
                }
                return false;
            }
        }
        if(nums[nums.length-1] > nums[0]){
            return find(nums,0,nums.length-1,target);
        }
        int left = 0;
        int right = nums.length-1;
        while (left!=right){
            int mid = (left + right)>>1;
            if(nums[mid]>=nums[0]){
                left = mid + 1;
            }else if(nums[mid] < nums[0]){
                right = mid;
            }
        }
        if(target >= nums[0]){
            left = 0;
            right = right - 1;
        }else{
            right = nums.length - 1;
        }
        return find(nums,left,right,target);
    }

    boolean find(int[] arr, int left, int right, int target) {
        while (left != right) {
            int mid = (left + right) >> 1;
            if (arr[mid] > target) {
                right = mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                return true;
            }
        }
        return arr[left] == target ? true : false;
    }

    @Test
    public void test1(){
        boolean search = search(new int[]{1}, 1);
    }
}
