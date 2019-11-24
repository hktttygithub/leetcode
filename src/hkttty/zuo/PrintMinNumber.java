package hkttty.zuo;

import java.util.ArrayList;
import java.util.Collections;

public class PrintMinNumber {
    public String printMinNumber(int [] numbers) {
        ArrayList<String> list = new ArrayList();
        for(int val : numbers){
            list.add(String.valueOf(val));
        }
        Collections.sort(list,(String s1,String s2)->{
           String s1s2 = s1 + s2;
           String s2s1 = s2 + s1;
//           s1.compareTo(s2);
           if(s1s2.length()==s2s1.length()){
               for (int i=0;i<s1s2.length();i++){
                   char c1 = s1s2.charAt(i);
                   char c2 = s2s1.charAt(i);
                   if(c1==c2){
                       continue;
                   }else{
                       return c1 - c2;
                   }
               }
               return 0;
           }
            return s1s2.length() - s2s1.length();
        });

        StringBuilder res = new StringBuilder();
        for(String str : list){
            res.append(str);
        }
        return new String(res);
    }
}
