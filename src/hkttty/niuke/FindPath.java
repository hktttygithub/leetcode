package hkttty.niuke;

import hkttty.leetcode.TreeNode;
import org.junit.Test;

import java.util.ArrayList;

public class FindPath {
    int target;
    ArrayList<ArrayList<Integer>> list1 = new ArrayList<>();


    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if(root==null){
            return list1;
        }
        this.target = target;
        helper(root,0,new ArrayList<Integer>());
        list1.sort((ArrayList<Integer> help1,ArrayList<Integer> help2)
                -> (help2.size()-help1.size()));
        return list1;
    }
    void helper(TreeNode root,int sum,ArrayList<Integer> list2){
        if(root==null){
            return;
        }
        int val = root.val;
        list2.add(val);
        sum = sum + val;
        helper(root.left,sum,new ArrayList<>(list2));
        helper(root.right,sum,list2);
        if(sum==target){
            list1.add(list2);
        }
    }

    @Test
    public void test1(){
        ArrayList<Integer> listTest = new ArrayList<>();
        listTest.add(2);
        listTest.add(1);
        listTest.add(-5);
        listTest.add(4);
        listTest.add(2);
        listTest.add(1);
        listTest.add(10);
        listTest.add(null);
        listTest.add(null);
        listTest.add(null);
        listTest.add(null);
        listTest.add(7);
        TreeNode build = TreeNode.build(listTest);
        ArrayList<ArrayList<Integer>> arrayLists = FindPath2(build, 5);
    }


    //牛客
    private ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> list = new ArrayList<Integer>();
    public ArrayList<ArrayList<Integer>> FindPath2(TreeNode root,int target) {
        if(root == null) return listAll;
        list.add(root.val);
        target -= root.val;
        if(target == 0 && root.left == null && root.right == null)
            listAll.add(new ArrayList<Integer>(list));
        FindPath2(root.left, target);
        FindPath2(root.right, target);
        list.remove(list.size()-1); //节省内存空间
        return listAll;
    }


}
