package hkttty.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class No103 {

    @Test
    public void test1() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(6);
        list.add(7);
        list.add(5);
        TreeNode head = TreeNode.build(list);
        List<List<Integer>> lists = zigzagLevelOrder(head);
        System.out.println(lists.toString());
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> list1 = new ArrayList<>();
        LinkedList<TreeNode> deque = new LinkedList<>();
        deque.addLast(root);
        boolean revFlag = false;
        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> list2 = new ArrayList<>();
            LinkedList<Integer> help = new LinkedList<>();
            while (size > 0) {
                TreeNode node = deque.pollFirst();
                help.addLast(node.val);
                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
                size--;
            }
            if(revFlag) {
                while (!help.isEmpty()) {
                    list2.add(help.pollLast());
                }
            }else {
                while(!help.isEmpty()){
                    list2.add(help.pollFirst());
                }
            }
            revFlag = !revFlag;
            list1.add(list2);
        }
        return list1;
    }

}
