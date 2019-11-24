package hkttty.leetcode;

import org.junit.Test;

public class No10 {

    public boolean isMatch(String text, String pattern) {
        if (pattern.isEmpty()) return text.isEmpty();
        boolean first_match = (!text.isEmpty() &&
                (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

        if (pattern.length() >= 2 && pattern.charAt(1) == '*'){
            return (isMatch(text, pattern.substring(2)) ||
                    (first_match && isMatch(text.substring(1), pattern)));
        } else {
            return first_match && isMatch(text.substring(1), pattern.substring(1));
        }
    }

    @Test
    public void test1() {
//        System.out.println("a".substring(1));
        boolean aab = isMatch("aaa", "a*a");
        System.out.println(aab);
    }

    // public String substring(int beginIndex)
    //返回一个新字符串，它是此字符串的一个子字符串。
    // 该子字符串始于指定索引处的字符，一直到此字符串末尾。
    //参数：beginIndex - 开始处的索引（包括），
}
