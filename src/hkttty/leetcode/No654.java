package hkttty.leetcode;

import org.junit.Test;

public class No654 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    @Test
    public void test1() {
        int []a = new int[]{3,2,1,6,0,5};
        TreeNode treeNode = constructMaximumBinaryTree(a);
        System.out.println(treeNode.val);
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null)
            return null;
        return maxTree(nums, 0, nums.length - 1);
    }



    TreeNode maxTree(int[] nums, int start, int end) {
        if (start<end) {
            return null;
        }
        int maxIndex = start;
        for (int i = start; i <= end; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }
        TreeNode head = new TreeNode(nums[maxIndex]);
        head.left = maxTree(nums, start, maxIndex-1);
        head.right = maxTree(nums, maxIndex + 1, end);
        return head;

    }

}
