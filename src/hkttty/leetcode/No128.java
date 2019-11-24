package hkttty.leetcode;

import java.util.HashMap;

public class No128 {
    //给定一个未排序的整数数组，找出最长连续序列的长度。
    //要求算法的时间复杂度为 O(n)。
    HashMap<Integer,Integer> headMap = new HashMap<>(64);
    HashMap<Integer,Integer> size = new HashMap<>();
    int maxSize = 1;

    public int longestConsecutive(int[] nums) {
        if(nums==null || nums.length<=0){
            return 0;
        }

        for(int i=0;i< nums.length;i++){
            headMap.put(nums[i],nums[i]);
            size.put(nums[i],1);
        }
        for(int i=0;i<nums.length;i++){
            if(headMap.containsKey(nums[i]-1)){
                //这里一定要写findHead!!!!!不能只找第一个头结点，得递归去找！！！
                int head1 = findHead(nums[i]);
                int head2 = findHead(nums[i] - 1);
                if(head1==head2){
                    continue;
                }
                headMap.put(head2,head1);
                int size1 = size.get(head1);
                int size2 = size.get(head2);
                size.put(head1,size1 + size2);
                maxSize = (size1 +size2) > maxSize ? (size1 +size2) : maxSize;
            }
        }
        return maxSize;
    }

    private int findHead(int node) {
        int head = headMap.get(node);
        if(node!=head){
            head = findHead(head);
        }
        headMap.put(node,head);//压缩路径
        return head;
    }
}
