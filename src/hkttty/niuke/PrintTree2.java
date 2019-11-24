package hkttty.niuke;

import hkttty.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

public class PrintTree2 {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot==null){
            return res;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        while (!queue.isEmpty()){
            int size =  queue.size();
            ArrayList<Integer> list = new ArrayList();
            while (size>0){
                size--;
                TreeNode node = queue.pollFirst();
                list.add(node.val);
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
            res.add(list);
        }
        return res;
    }
}
