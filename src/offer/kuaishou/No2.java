package offer.kuaishou;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class No2 {
    static HashMap<String,String> map = new HashMap<>();
    static {
        map.put("2","abc");
        map.put("3","def");
        map.put("4","ghi");
        map.put("5","jkl");
        map.put("6","mno");
        map.put("7","pqrs");
        map.put("8","tuv");
        map.put("9","wxyz");
    }
    static StringBuffer buffer = new StringBuffer("[");

    public static void main(String[] args) {
        String input = new Scanner(System.in).nextLine();
        back("",input);
        buffer.deleteCharAt(buffer.length()-1);
        buffer.deleteCharAt(buffer.length()-1);
        buffer.append("]");
//        System.out.println(buffer.equals("[wa, wb, wc, xa, xb, xc, ya, yb, yc, za, zb, zc]"));
        System.out.println(buffer);
    }
//[ad, ae, af, bd, be, bf, cd, ce, cf]
    private static void back(String s1,String s2) {
        if(s2.length()==0){
            buffer.append(s1 + ", ");
        }else{
            String d1 = s2.substring(0,1);
            String l = map.get(d1);
            for(int i=0;i<l.length();i++){
                String l2 = map.get(d1).substring(i,i+1);
                back(s1 + l2,s2.substring(1));
            }
        }

    }
}
