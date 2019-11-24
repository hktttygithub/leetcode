package hkttty.niuke;

import org.junit.Test;

public class OneTimes {
    public int FirstNotRepeatingChar(String str) {
        int []times =  new int[128];
        for(int i = 0;i<str.length();i++){
            char c = str.charAt(i);
            times[(int)c] = times[(int)c] + 1;
        }
        for(int i = 0 ;i<str.length();i++){
            int index = (int)str.charAt(i);
            if(times[index]==1){
                return i;
            }
        }
        return -1;
    }

    @Test
    public void test1(){
        int google = FirstNotRepeatingChar("google");
        System.out.println((int)1000000007);
    }
}
