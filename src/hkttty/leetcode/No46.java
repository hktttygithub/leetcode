package hkttty.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class No46 {
    List<List<Integer>> list = new ArrayList<>();
    ArrayList<Integer> list2 = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        if(nums==null || nums.length==0){
            return list;
        }
        helper(nums,0,new boolean[nums.length]);
        return list;
    }

    void helper(int []arr,int index,boolean []flag){
        if(list2.size()==arr.length){
            list.add(new ArrayList<>(list2));
        }
        for(int i=0;i<arr.length;i++){
            if(!flag[i]){
                list2.add(arr[i]);
                flag[i] = true;
                helper(arr,index+1,flag);
                flag[i] = false;
                list2.remove(list2.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> permute = new No46().permute(new int[]{1, 2, 3});
        System.out.println(permute.toString());

    }
}
