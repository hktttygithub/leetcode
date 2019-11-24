package hkttty.niuke;

import hkttty.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MInKTree {

    TreeNode res = null;
    int cur = 1;

    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null) {
            return null;
        }
        helper(pRoot, k);
        return res;
    }

    void helper(TreeNode pRoot, int k) {
        if (pRoot == null || res!=null) {
            return;
        }
        helper(pRoot.left, k);
        if (cur++ == k) {
            res = pRoot;
            return;
        }
        helper(pRoot.right, k);

    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{8,6,10,5,7,9,11};
        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list, arr);
        TreeNode head = TreeNode.build(list);
        TreeNode treeNode = new MInKTree().KthNode(head, 1);
        System.out.println(treeNode.val);
    }


}
