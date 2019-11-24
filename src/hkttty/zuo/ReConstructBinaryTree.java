package hkttty.zuo;

import hkttty.leetcode.TreeNode;
import org.junit.Test;

import java.util.HashMap;

public class ReConstructBinaryTree {

    HashMap<Integer, Integer> map = new HashMap<>();
    int[] pre;
    int[] in;
    int preIndex = 0;

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || in == null || pre.length != in.length) {
            return null;
        }
        this.pre = pre;
        this.in = in;
        for (int i = 0; i < in.length; i++) {
            map.put(in[i], i);
        }
        return helper(0, in.length);
    }

    TreeNode helper(int inLeft, int inRight) {
        if (inLeft == inRight) {
            return null;
        }
        TreeNode node = new TreeNode(pre[preIndex]);
        int index = map.get(preIndex++);
        node.left = helper(inLeft, index);
        node.right = helper(index + 1, inRight);
        return node;
    }


}
