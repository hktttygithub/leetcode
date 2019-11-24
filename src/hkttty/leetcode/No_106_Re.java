package hkttty.leetcode;

import java.util.HashMap;

public class No_106_Re {
    HashMap<Integer,Integer> map = new HashMap<>();
    int index;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.index = postorder.length-1;
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return build(postorder,0,postorder.length);
    }

    private TreeNode build(int[] postorder, int left, int right) {
        if(left==right){
            return null;
        }
        TreeNode node = new TreeNode(postorder[index--]);
        int inIndex = map.get(node.val);
        node.right =  build(postorder,inIndex+1,right);
        node.left =  build(postorder,left,inIndex);
        return node;
    }
}
