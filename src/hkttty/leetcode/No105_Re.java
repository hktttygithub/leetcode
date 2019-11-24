package hkttty.leetcode;

import java.util.HashMap;

public class No105_Re {
    int preIndex = 0;
    HashMap<Integer,Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int index=0;
        for(int val : inorder){
            map.put(val,index++);
        }
        return build(preorder,inorder,0,preorder.length);
    }

    private TreeNode build(int[] preorder, int[] inorder,int left,int right) {
        if(left==right){
            return null;
        }
        TreeNode node = new TreeNode(preorder[preIndex++]);
        int inIndex = map.get(node.val);
        node.left = build(preorder,inorder,left,inIndex);
        node.right = build(preorder,inorder,inIndex+1,right);
        return node;
    }
}
