package hkttty.leetcode;

import org.junit.Test;

import java.util.Arrays;

public class No69_Re {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        long left = 0;
        long right = x;
        while (left != right) {
            long mid = (left + right)>>>1;
            if (mid * mid > x) {
                right = mid;
            } else if (mid * mid <= x && (mid + 1) * (mid + 1) > x) {
                return (int)mid;
            } else {
                // mid * mid < x
                left = mid + 1;
            }
        }
        return (int)left;
    }
    
    @Test
    public void test1(){
        int i = mySqrt(2147395599);
        System.out.println(i);

        Arrays.fill(new int[10],1);
    }
}
