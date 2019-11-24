package hkttty.leetcode;

import org.junit.Test;

import java.util.HashSet;

public class Bigo {
    int max = 0;

    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.length()<=0){
            return 0;
        }
        if(s.length()==1){
            return 1;
        }
        char []cArr = s.toCharArray();
        HashSet<Character> set;
        for(int i=0;i<cArr.length;i++){
            int length=0;
            set = new HashSet<>();
            for(int j=i;j<cArr.length;j++){
                if(set.add(cArr[j])){
                    length++;
                }else{
                    if(length>max){
                        max = length;
                    }
                    break;
                }
            }
        }
        return max;
    }

    @Test
    public void test1(){
        int au = lengthOfLongestSubstring("au");
        System.out.println(au);
    }
}
