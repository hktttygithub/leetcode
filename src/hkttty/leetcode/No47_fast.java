package hkttty.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No47_fast {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums == null || nums.length < 1) {
            return result;
        }
        Arrays.sort(nums);
        permuteDFS(nums, 0, result);
        return result;
    }

    public void permuteDFS(int[] nums, int start, List<List<Integer>> res) {
        if (start == nums.length - 1) {
            List<Integer> list = new ArrayList<>();
            for (int i : nums) {
                list.add(i);
            }
            res.add(list);
        }
        for (int i = start; i < nums.length; ++i) {
            int j = i - 1;
            while (j >= start && nums[j] != nums[i])
                --j;
            if (j != start - 1)
                continue;
            swap(nums, start, i);
            permuteDFS(nums, start + 1, res);
            swap(nums, start, i);
        }
    }

    public void swap(int[] nums, int a, int b) {
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }
}
