package hkttty.leetcode;

import java.util.PriorityQueue;

public class No215_Sec {
    //最小堆
    PriorityQueue<Integer> queue = new PriorityQueue<Integer>();

    public int findKthLargest(int[] input, int k) {
        if (input == null || k > input.length || k <= 0) {
            return 0;
        }
        for (int i = 0; i < k; i++) {
            queue.add(input[i]);
        }
        for (int i = k; i < input.length; i++) {
            if (input[i] > queue.peek()) {
                queue.poll();
                queue.add(input[i]);
            }
        }
        return queue.poll();
    }

    //要实现最小堆
    void heapInsert(int[] nums, int index) {
        int parrent = (index - 1) / 2;
        while (index > 0) {
            if (nums[parrent] < nums[index]) {
                return;
            } else {
                swap(nums,index,parrent);
                index = parrent;
                parrent = (index - 1) / 2;
            }
        }
    }

    //弹出
    void poll(int []nums){
        swap(nums,0,nums.length-1);
        int parent = 0;
        int son = (parent + 1) *2;
        while (son<nums.length-1){
            int minSon = (nums[son+1] <  nums.length-1 ) && (nums[son+1] < nums[son]) ? nums[son+1] : nums[son];
            if(nums[parent] < nums[minSon]){
                return;
            }else{
                swap(nums,parent,minSon);
                minSon =parent;

            }
        }
    }

    private void swap(int []nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = nums[i];
    }


}
