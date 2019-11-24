package hkttty.tree;

import org.junit.Test;

//判断是否平衡二叉树
public class IsBalanced {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    @Test
    public void test1(){

    }


    public boolean isB(TreeNode root) {
        int h = check(root);
        if (h == -1) {
            return false;
        }
        return true;
    }

    int check(TreeNode root) {
        if (root == null)
            return 0;
        int left = check(root.left);
        if (left == -1) {
            return -1;
        }
        int right = check(root.right);
        if (right == -1) {
            return -1;
        }
        return (left > right) ? 1 + left : 1 + right;
    }
}
