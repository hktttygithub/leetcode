package hkttty.niuke;

import hkttty.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

//层序遍历
public class printTree {
    ArrayList<Integer> res = new ArrayList<>();
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        if(root==null){
            return res;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        while(!queue.isEmpty()){
            root = queue.pollFirst();
            res.add(root.val);
            if(root.left!=null){
                queue.addLast(root.left);
            }
            if(root.right!=null){
                queue.addLast(root.right);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode par = TreeNode.deserialize("8,8,7,9,2,#,#,#,#,4,7,#,#,#,#");
        ArrayList<Integer> integers = new printTree().PrintFromTopToBottom(par);
        System.out.println(integers);
    }

}
