package hkttty.leetcode;

public class No236Sec {
    TreeNode res = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helper(root, p, q);
        return res;
    }

    boolean helper(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null || res!=null ) { // 剪枝
            return false;
        }
        int left = helper(root.left, p, q) ? 1 : 0;
        int right = helper(root.right, p, q) ? 1 : 0;
        int mid = (root==p || root==q) ? 1 : 0;
        if(left + right + mid >1){
            res = root;
        }
        return left + right + mid >0;
    }
}
