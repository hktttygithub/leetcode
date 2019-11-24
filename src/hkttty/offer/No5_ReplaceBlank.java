package hkttty.offer;

import org.junit.Test;

//替换空格
//请实现一个函数，把字符串中的每个空格替换成“%%%%%”
//注意：需要在原有的字符串上进行替换
public class No5_ReplaceBlank {

    @Test
    public void test1() {
        char[] str = new char[]{'w', 'e', ' ', 'a', 'r', 'e', ' ', 'h', 'a', 'p', 'p', 'y'};
        char[] chars = new char[100];
        for (int i = 0; i < str.length; i++) {
            chars[i] = str[i];
        }
        replace(chars);
    }

    public void replace(char[] str) {
        int count = 0;
        int p = 0;
        for (char c : str) {
            if (c == ' ') {
                count++;
            } else if (c == '\0') {
                break;
            }
            p++;
        }
        //替换成%%%%%，每个空格需要增加4个位置
        if (count == 0) {
            return;
        }
        int countN = count * 4;
        int q = p + countN;
        int length = q;
        while (count > 0) {
            while (str[p] != ' ') {
                str[q--] = str[p--];
            }
            for (int i = 0; i < 5; i++) {
                str[q--] = '%';
            }
            count--;
            p--;
        }
        for (int i = 0; i < str.length; i++) {
            System.out.print(str[i]);
        }
    }

    @Test
    public void test2(){
        String hello_world = replaceSpace(new StringBuffer("hello world"));
        System.out.println(hello_world);
    }

    //牛客
    public String replaceSpace(StringBuffer str) {
        if (str == null || str.length() == 0) {
            return str.toString();
        }
        int cLength = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == ' ') {
                cLength++;
            }
        }
        if (cLength == 0) {
            return str.toString();
        }
        char[] cArray = new char[str.length() + cLength * 2];
        for (int i = 0; i < str.length(); i++) {
            cArray[i] = str.charAt(i);
        }
        int p = str.length() - 1;
        int q = cArray.length - 1;
        while (cLength > 0) {
            if (cArray[p] == ' ') {
                p--;
                cArray[q--] = '0';
                cArray[q--] = '2';
                cArray[q--] = '%';
                cLength--;
            } else {
                cArray[q--] = cArray[p--];
            }
        }
        return new String(cArray);
    }

    public class Solution {
        public String replaceSpace(StringBuffer str) {
            StringBuffer out=new StringBuffer();
            for (int i = 0; i < str.toString().length(); i++) {
                char b=str.charAt(i);
                if(String.valueOf(b).equals(" ")){
                    out.append("%20");
                }else{
                    out.append(b);
                }
            }
            return out.toString();
        }
    }
}
