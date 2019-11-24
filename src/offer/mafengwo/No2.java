package offer.mafengwo;


import hkttty.niuke.youzan.Main;

import java.util.LinkedList;
import java.util.Scanner;

public class No2 {
    class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(String val){
            this.val = Integer.valueOf(val);
        }

        TreeNode(){}

        TreeNode build(String str){
            String[] s = str.split(",");
            LinkedList<TreeNode> list = new LinkedList<>();
            TreeNode head = new TreeNode(s[0]);
            list.add(head);
            int i = 1;
            while(i<s.length){
                TreeNode node = list.poll();
                node.left = new TreeNode(s[i++]);
                list.add(node.left);
                node.right = new TreeNode(s[i++]);
                list.add(node.right);
            }
            return head;
        }
    }

    static int find =0;
    static int next = -1;
    static boolean flag = false;

    void print(TreeNode head){
        if(flag){
            next = (head==null ? -1 : head.val);
            return;
        }
        if(head==null){
            return;
        }
        print(head.left);
        if (head.val==find){
            flag=true;
        }
        print(head.right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        find = Integer.valueOf(s2);
        new No2().go(s1,s2);
        System.out.println(next);
    }

    void go(String str,String s2){
        TreeNode head = new TreeNode().build(str);
        print(head);
    }
}
