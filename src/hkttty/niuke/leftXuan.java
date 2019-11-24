package hkttty.niuke;

import org.junit.Test;

//恩，没错，这就是左旋
public class leftXuan {
    public String LeftRotateString(String str,int n) {
        StringBuffer buffer = new StringBuffer(str);
        buffer.append(str);

        StringBuffer res = new StringBuffer();
        for(int i=n;i<n+str.length();i++){
            res.append(buffer.charAt(i));
        }
        System.out.println(res.toString());
        return new String(res);
    }

    @Test
    public void test1(){
        LeftRotateString("abcXYZdef",3);
    }
}
