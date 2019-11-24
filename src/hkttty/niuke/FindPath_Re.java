package hkttty.niuke;

import hkttty.leetcode.TreeNode;

import java.util.ArrayList;

public class FindPath_Re {
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) {
            return res;
        }
        preTravel(root, target, new ArrayList<Integer>());
        return res;
    }

    private void preTravel(TreeNode root, int target, ArrayList<Integer> list) {
        if (root == null || target < 0) {
            return;
        }
        target = target - root.val;
        list.add(root.val);
        if (target == 0) {
            if (root.left == null && root.right == null) {
                res.add(new ArrayList<>(list));
            }
            list.remove(list.size()-1);
            return;
        }
        preTravel(root.left, target, list);
        preTravel(root.right, target, list);
        list.remove(list.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode deserialize = TreeNode.deserialize("10,5,12,4,7,#,#,#,#,#,#");
        System.out.println(new FindPath_Re().FindPath(deserialize,22));
    }
}
