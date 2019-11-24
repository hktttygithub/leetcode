package hkttty.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class No17 {
    HashMap<Character,String> map = new HashMap<>();
    {
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
    }
    ArrayList<String> list = new ArrayList<>();

    public List<String> letterCombinations(String str) {
        if(str==null || str.length()==0){
            return list;
        }
        char[] chars = str.toCharArray();
        find(chars,0,new StringBuilder(""));
        return list;
    }

    private void find(char[] chars, int index,StringBuilder str) {
        if(index==chars.length){
            list.add(new String(str));
            return;
        }
        String s = map.get(chars[index]);
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            str.append(c);
            find(chars,index+1,str);
            str.deleteCharAt(str.length()-1);
        }
    }
}
