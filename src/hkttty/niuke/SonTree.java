package hkttty.niuke;

import hkttty.leetcode.TreeNode;

//题目描述
//输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
public class SonTree {
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if(root2==null){
            return false;
        }
        return travel(root1,root2);
    }

    boolean travel(TreeNode root1,TreeNode root2){
        if(root1==null){
            return false;
        }
        return check(root1,root2) ||
                travel(root1.left,root2) ||
                travel(root1.right,root2);
    }

    boolean check(TreeNode root1,TreeNode root2){
        if(root2==null){
            return true;
        }
        if(root1==null || root1.val!=root2.val){
            return false;
        }
        return check(root1.left,root2.left) &&
                check(root1.right,root2.right);
    }

    public static void main(String[] args) {
        //{8,8,7,9,2,#,#,#,#,4,7},{8,9,2}
        TreeNode par = TreeNode.deserialize("8,8,7,9,2,#,#,#,#,4,7,#,#,#,#");
        TreeNode son = TreeNode.deserialize("8,9,2,#,#,#,#");
        boolean b = new SonTree().HasSubtree(par, son);
        System.out.println(b);
    }
}
