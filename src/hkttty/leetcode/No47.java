package hkttty.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class No47 {
    List<List<Integer>> res = new ArrayList<>();
    HashSet<String> set = new HashSet<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return res;
        }
        dfs(nums, new boolean[nums.length], new ArrayList<Integer>());
        return res;

    }

    private void dfs(int[] nums, boolean[] help, List<Integer> list) {
        if (list.size() == nums.length) {
            StringBuilder str = new StringBuilder();
            for (Integer val : list) {
                str.append(val);
            }
            if (set.add(new String(str))) {
                res.add(new ArrayList<>(list));
            }
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (help[i]) {
                continue;
            }
            help[i] = true;
            list.add(nums[i]);
            dfs(nums, help, list);
            list.remove(list.size() - 1);
            help[i] = false;
        }

    }


}
