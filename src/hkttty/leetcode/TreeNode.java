package hkttty.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;

public class TreeNode {


    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    //反序列化
    public static TreeNode deserialize(String str) {
        if (str.equals("#")) {
            return null;
        }
        String[] split = str.split(",");
        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode head = new TreeNode(Integer.valueOf(split[0]));
        TreeNode node = head;
        queue.addLast(head);
        int index = 1;
        while (!queue.isEmpty()) {
            node = queue.pollFirst();
            node.left = buildTree(split[index++]);
            node.right = buildTree(split[index++]);
            if (node.left != null) {
                queue.addLast(node.left);
            }
            if (node.right != null) {
                queue.addLast(node.right);
            }
        }
        return head;
    }

    //层序遍历
    public static void printAll(TreeNode head) {
        System.out.println();
        if (head == null) {
            System.out.print("#");
            return;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(head);
        while (!queue.isEmpty()) {
            head = queue.pollFirst();
            if(head==null){
                System.out.print("#" + ",");
                continue;
            }
            System.out.print(head.val + ",");
            queue.addLast(head.left);
            queue.addLast(head.right);

        }

    }

    private static TreeNode buildTree(String s) {
        if (s.equals("#")) {
            return null;
        }
        return new TreeNode(Integer.valueOf(s));
    }


    public static TreeNode build(ArrayList<Integer> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        TreeNode head = new TreeNode(list.get(0));
        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode node = head;
        queue.offer(node);
        for (int i = 1; i < list.size(); ) {
            node = queue.poll();
            if (list.get(i) == null) {
                node.left = null;
                i++;
            } else {
                node.left = new TreeNode(list.get(i++));
            }
            if (i == list.size()) {
                break;
            }
            if (list.get(i) == null) {
                node.right = null;
                i++;
            } else {
                node.right = new TreeNode(list.get(i++));
            }

            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return head;
    }

}
