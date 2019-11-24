/*
package hkttty.leetcode;

import java.util.HashMap;
import java.util.HashSet;

public class No76 {
    //给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：
    // 包含 T 所有字母的最小子串。
    public String minWindow(String s, String t) {
        HashSet<Character> set = new HashSet<>();
        for(char c : t.toCharArray()){
           set.add(c);
        }

        int left = 0;
        int right = 0;
        char[] arr = s.toCharArray();
        HashMap<Character,Integer> map = new HashMap<>();
        while (right<arr.length){
            if(set.contains(arr[right])){
                map.put(arr[right],right);
            }

        }
    }
}
*/
