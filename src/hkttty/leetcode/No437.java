package hkttty.leetcode;

import org.junit.Test;

import java.util.ArrayList;

public class No437 {


    int sum;
    int count = 0;

    @Test
    public void test1(){
        //[10,5,-3,3,2,null,11,3,-2,null,1]
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(5);
        list.add(-3);
        list.add(3);
        list.add(2);
        list.add(null);
        list.add(11);
        list.add(3);
        list.add(-2);
        list.add(null);
        list.add(1);
        TreeNode build = TreeNode.build(list);
        int i = pathSum(build, 8);
        System.out.println(i);
    }

    public int pathSum(TreeNode root, int sum) {
        this.sum = sum;
        help(root, new int[]{});
        return count;
    }

    void help(TreeNode root, int[] arr) {
        if (root == null) {
            return;
        }
        int []arr2 = new int[arr.length + 1];
        for (int i = 0; i < arr2.length - 1; i++) {
            arr2[i] = arr[i] + root.val;
            if (arr2[i] == sum) {
                count++;
            }
        }
        arr2[arr2.length - 1] = root.val;
        if (root.val == sum) {
            count++;
        }
        help(root.left, arr2);
        help(root.right, arr2);
    }

}
