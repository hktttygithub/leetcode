package hkttty.leetcode;

import java.util.HashMap;

public class  No106 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        HashMap<Integer,Integer> map = new HashMap<>();
        int posIndex;

        public TreeNode buildTree(int[] inorder, int[] postorder) {
            if(inorder==null || postorder==null ||
                    inorder.length<=0 || inorder.length!=postorder.length){
                return null;
            }
            int i =0;
            for(int val : inorder){
                map.put(val,i++);
            }
            posIndex = postorder.length-1;
            return helper(0,inorder.length-1,postorder);
        }

        TreeNode helper(int left,int right,int []postorder){
            if(right<left){
                return null;
            }
            int val = postorder[posIndex--];
            TreeNode node = new TreeNode(val);
            int inIndex = map.get(val);
            node.right = helper(inIndex+1,right,postorder);
            node.left = helper(left,inIndex-1,postorder);
            return node;
        }
    }
}
