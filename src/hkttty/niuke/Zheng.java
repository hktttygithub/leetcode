package hkttty.niuke;

public class Zheng {
    public class Solution {
        public double Power(double base, int exponent) {
            if (exponent == 0) {
                return 1.0;
            }
            if (base == 0) {
                return 0.0;
            }
            if (exponent < 0) {
                return go(1 / base, exponent);
            } else {
                return go(base, exponent);
            }
        }

        double go(double base, int n) {
            double res = 1;
            while (n-- > 0) {
                res = res * base;
            }
            return res;
        }
    }

}
