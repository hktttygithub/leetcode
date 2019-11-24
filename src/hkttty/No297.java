package hkttty;

import hkttty.leetcode.TreeNode;
import org.junit.Test;

import java.util.LinkedList;

public class No297 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder res = new StringBuilder("");
        res.append("[");
        if(root==null){
            res.append("]");
            return res.toString();
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        while(!queue.isEmpty()){
            root = queue.pollFirst();
            res.append(root.val + ",");
            if(root.left!=null){
                queue.addLast(root.left);
            }
            if(root.right!=null){
                queue.addLast(root.right);
            }
        }
        res.delete(res.length()-1,res.length());
        res.append("]");
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data==null || data.equals("")){
            return null;
        }
        char c[] = data.toCharArray();
        TreeNode head = new TreeNode(c[0]-'0');
        for(int i=1;i<data.length();i++){
            if(c[i]==','){
                continue;
            }
            TreeNode left;
            TreeNode right;
        }

            return null;
    }

    @Test
    public void test1(){
        int a =5;
        int b =20;
        a += b;
        System.out.println(a);
    }
}
