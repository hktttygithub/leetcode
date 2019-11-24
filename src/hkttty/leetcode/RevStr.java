package hkttty.leetcode;

import java.util.LinkedHashSet;

public class RevStr {
    public static void main(String[] args) {
        revStr("a1222234445611233zxc232a");
        String s1 = null;
        String s2 ="123";
        System.out.println(s1==s2);
    }

    //反转字符串，且去除字符串中的重复字符
    static String revStr(String str) {
        if (str == null || str.length() < 2) {
            return str;
        }
        LinkedHashSet<Character> charSet = new LinkedHashSet<>();

        for (int i = str.length()-1; i>=0; i--) {
            charSet.add(str.charAt(i));
        }
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.hashCode();
        str.hashCode();
        for(Character c : charSet){
            strBuilder.append(c);
        }
        str = new String(strBuilder);
        System.out.println(str);
        return str;
    }
}
