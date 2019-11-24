package hkttty.leetcode;

import org.junit.Test;

import java.util.ArrayList;

public class No230 {

    int number;
    int k;
    int count=0;

    @Test
    public void test1(){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(1);
        list.add(4);
        list.add(null);
        list.add(2);
        list.add(10);
        list.add(12);
        list.add(23);
        list.add(20);
        list.add(21);
        list.add(21);
        list.add(21);
        list.add(21);
        list.add(21);
        list.add(21);
        list.add(21);
        list.add(21);
        list.add(21);
        list.add(21);
        list.add(21);
        list.add(21);
        list.add(21);
        list.add(21);
        list.add(21);
        list.add(21);
        list.add(21);
        list.add(21);
        list.add(21);
        list.add(21);
        list.add(21);
        list.add(21);
        list.add(21);
        list.add(21);
        list.add(21);
        list.add(21);
        list.add(21);
        list.add(21);
        list.add(21);
        TreeNode tree = TreeNode.build(list);
        int i = kthSmallest(tree, 1);
        System.out.println(count);
    }

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        help(root);
        return number;
    }

    void help(TreeNode node){
        if(node==null){
            return;
        }
        if(k<0){
            return;
        }
        help(node.left);
        --k;
        if(k==0){
            number = node.val;
            return;
        }

        count++;
        help(node.right);
    }
}
