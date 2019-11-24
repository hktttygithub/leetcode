package hkttty.leetcode;

import org.junit.Test;

public class No69 {
    @Test
    public void test1() {
        System.out.println(mySqrt(4));
    }

    public int mySqrt(int x) {
        int y = x / 2 + 1;

        return find(0, y, (long) x);
    }

    int find(int start, int end, long x) {
        if (start > end) {
            return -1;
        }

        long mid = (long) ((start + end) >> 1);
        long temp = mid * mid;
        long temp2 = (mid + 1) * (mid + 1);

        if (temp > x) {
            return find(start, (int) mid - 1, x);
        } else if (temp <= x && temp2 > x) {
            return (int) mid;
        } else {
            return find((int) mid + 1, end, x);
        }
    }


}
