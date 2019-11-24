package hkttty.niuke;

import hkttty.leetcode.TreeNode;

import java.util.HashMap;

//题目描述
//输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
// 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
// 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
public class ReConstructBinaryTree {
    HashMap<Integer,Integer> map = new HashMap<>();
    int index=0;

    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        int i = 0 ;
        for(int val : in){
            map.put(val,i++);
        }
        return build(pre,in,0,in.length);
    }

    private TreeNode build(int[] pre, int[] in, int left, int right) {
        if(left>=right){
            return null;
        }
        int root = pre[index++];
        TreeNode node = new TreeNode(root);
        int inIndex = map.get(root);
        node.left = build(pre,in,left,inIndex);
        node.right = build(pre,in,inIndex+1,right);
        return node;
    }
}
