package hkttty.leetcode;

import java.util.HashMap;
import java.util.HashSet;

public class No3 {
    //给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int max = 0;
        char []arr = s.toCharArray();
        while (right<s.length()){
            if(map.containsKey(arr[right])){
                left = Math.max(left,map.get(arr[right]) + 1); //这行是关键
            }
            map.put(arr[right],right);
            max = Math.max(max,right-left+1);
            right++;
        }
        return max;
    }

    public static void main(String[] args) {
        int tmmzuxt = new No3().lengthOfLongestSubstring("tmmzuxt");
        System.out.println(tmmzuxt);
    }
}
