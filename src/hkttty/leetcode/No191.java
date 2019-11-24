package hkttty.leetcode;

import org.junit.Test;

public class No191 {
    @Test
    public void test1(){
    }

    public int hammingWeight(int n) {


        String s = String.valueOf(n);
        int count = 0;
        for(char c : s.toCharArray()){
            if(c=='1'){
                ++count;
            }
        }
        return count;
    }
}
