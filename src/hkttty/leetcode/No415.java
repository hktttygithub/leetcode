package hkttty.leetcode;

public class No415 {
    public String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder("");
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry= 0;
        while (i >= 0 || j >= 0) {
            int n1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int n2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            int temp = n1 + n2 + carry;
            carry  = temp/10;
            res.append(temp%10);
        }
        if(carry>0){
            res.append(carry);
        }
        return res.reverse().toString();
    }

}
