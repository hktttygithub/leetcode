package hkttty.leetcode;

import org.junit.Test;

import java.util.*;

public class No239 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        LinkedList<Integer> queue = new LinkedList<>();
        int []res = null;
        if(nums==null || nums.length<=0 || k<=0){
            return new int[0];
        }
        res = new int[nums.length-k+1];
        int index = 0;

        for(int i=0;i<nums.length;i++){
            while(!queue.isEmpty() && nums[queue.peekLast()]<=nums[i]){
                queue.pollLast();
            }
            queue.addLast(i);
            if(queue.peekFirst()==i-k){
                queue.pollFirst();
            }
            if(i>=k-1){
                res[index++] = nums[queue.peekFirst()];
            }
        }
        return res;
    }


    @Test
    public void test1() {
        int[] ints = maxSlidingWindow(new int[]{7, 2, 4}, 2);
        System.out.println(Arrays.toString(ints));
        HashMap map = new HashMap();
        map.remove("12");
        HashSet set = new HashSet();
        set.remove("swda");

    }
}
