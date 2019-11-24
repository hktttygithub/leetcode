package hkttty.niuke;

import java.util.ArrayList;
import java.util.HashSet;

//字符串的全排列
public class Permutation {
    ArrayList<String> res = new ArrayList<>();
    HashSet<String> help = new HashSet<>();

    public ArrayList<String> Permutation(String str) {
        if(str==null || str.length()==0){
            return res;
        }
        find(0, str.toCharArray(), new StringBuilder(""), new boolean[str.length()]);
        return res;
    }

    void find(int count, char[] arr, StringBuilder str, boolean[] flag) {
        if (count == arr.length) {
            String s = new String(str);
            if(help.add(s)){
                res.add(s);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (flag[i] == true) {
                continue;
            }
            flag[i] = true;
            str.append(arr[i]);
            find(count + 1, arr, str, flag);
            str.deleteCharAt(str.length() - 1);
            flag[i] = false;
        }

    }
}
