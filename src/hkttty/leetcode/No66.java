package hkttty.leetcode;

public class No66 {
    public int[] plusOne(int[] digits) {
        int[] res = new int[digits.length];
        int pre = (digits[digits.length - 1] + 1) / 10;
        res[digits.length - 1] = (digits[digits.length - 1] + 1) % 10;

        for (int i = digits.length - 2; i >= 0; i--) {
            int number = digits[i] + pre;
            res[i] = number % 10;
            pre = number / 10;
        }
        if (pre == 1) {
            int[] res2 = new int[res.length + 1];
            res2[0] = 1;
            for (int i = 1; i < res.length; i++) {
                res2[i] = res[i];
            }
            return res2;
        }
        return res;
    }
}
