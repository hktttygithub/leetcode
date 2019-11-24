package hkttty.leetcode;

import org.junit.Test;

import java.util.HashMap;

public class No152 {
    int count = 0;

    @Test
    public void test1() {
        System.out.println(
                maxProduct(new int[]{-5,2,4,1,-2,2,-6,3})
        );

    }

    int[] nums;
    int length;
    int max = Integer.MIN_VALUE;
    HashMap<String, Integer> map = new HashMap<>();

    public int maxProduct(int[] nums) {
        this.nums = nums;
        this.length = nums.length;
        findMax(0, 1);
        return max;
    }

    int findMax(int i, int total) {
        if (i == length) {
            return Integer.MIN_VALUE;
        }
        String key = i + "," + total + "   ";
        if(count++%5==0){
            System.out.println();
        }

        System.out.print(key);
//        if (map.containsKey(key)) {
//            return;
//        }

        total = nums[i] * total;
        if (total > max) {
            max = total;
        }
        map.put(key, total);

        //要当前数
        int t1= findMax(i + 1, total);
        //不要当前数
        int t2 =findMax(i + 1, 1);
        return 0;
    }


}
