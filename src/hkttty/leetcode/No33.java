package hkttty.leetcode;

import org.junit.Test;

public class No33 {
    //33. 搜索旋转排序数组
    //假设按照升序排序的数组在预先未知的某个点上进行了旋转。
    //( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
    //搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
    //你可以假设数组中不存在重复的元素。
    //你的算法时间复杂度必须是 O(log n) 级别。

    public int search(int[] nums, int target) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }
        if (nums[nums.length-1] >= nums[0]) {
            return find(nums,0,nums.length-1,target);
        }
        int left = 0;
        int right = nums.length - 1;
        while (left != right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] >= nums[0]) {
                left = mid + 1;
            } else if (nums[mid] < nums[0]) {
                right = mid;
            }
        }
        //跳出循环后，left一定到了小于区域的左边界
        if (target < nums[0]) {
            right = nums.length - 1;
        } else {
            //target在大于区域
            right = left - 1;
            left = 0;
        }
        int find = find(nums, left, right, target);
        return find;
    }

    int find(int[] arr, int left, int right, int target) {
        while (left != right) {
            int mid = (left + right) >> 1;
            if (arr[mid] > target) {
                right = mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return arr[left] == target ? left : -1;
    }

    @Test
    public void test1() {
        int search1 = search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3);
        int search2 = search2(new int[]{4, 5, 6, 7, 0, 1, 2}, 3);
        System.out.println(search1);
        System.out.println(search2);
    }

    public int search2(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) left = mid + 1;
            else right = mid;
        }
//        System.out.println(left);
        int split_t = left;
        left = 0;
        right = nums.length - 1;
        if (nums[split_t] <= target && target <= nums[right]) left = split_t;
        else right = split_t;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) right = mid - 1;
            else left = mid + 1;
        }
        return -1;

    }
}
