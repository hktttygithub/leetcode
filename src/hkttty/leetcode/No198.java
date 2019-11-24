package hkttty.leetcode;

import org.junit.Test;

import java.util.HashMap;

public class No198 {

    int[] nums;
    int length;
    HashMap<String, Integer> map = new HashMap<>();

    @Test
    public void test1(){
        //[1,2,1,1]
        int []arr = {1,2,1,1};
        int rob = rob(arr);
        System.out.println(rob);
    }

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        this.nums = nums;
        this.length = nums.length;
        int max1 = help(0, 0, false);

        return max1;
    }

    int help(int i, int sum, boolean flag) {
        if (i == length) {
            return sum;
        }
        int bigger = 0;
        String key = i - 1 + "" + String.valueOf(flag);
        if (map.containsKey(key)) {
            bigger = map.get(key);
        } else if (flag) {
            bigger = help(i + 1, sum, false);
            map.put(i + "false", bigger);
        } else {
            int max1 = help(i + 1, sum + nums[i], true);
            int max2 = help(i + 1, sum, false);
            if (max1 > max2) {
                bigger = max1;
                map.put(i + "true", bigger);
            } else {
                bigger = max2;
                map.put(i + "false", bigger);
            }
        }
        return bigger;

    }

}
