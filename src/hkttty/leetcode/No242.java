package hkttty.leetcode;

import java.util.Arrays;

public class No242 {
    public static void main(String[] args) {
        No242 no242 = new No242();
        boolean anagram = no242.isAnagram("anagram", "nagaram");
        System.out.println(anagram);

    }

    public  boolean isAnagram(String s, String t) {
        char [] c1 = s.toCharArray();
        char [] c2 = t.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        s = new String (c1);
        t = new String (c2);
        if(s.equals(t))
            return true;
        else
            return false;
    }

    void sortChar(char []c){
        for(int i=1;i<c.length;i++){
            for(int j=i;j>0 && c[j]>c[j-1];j--){
                swap(c,j,j-1);
            }
        }
    }

    void swap(char []c,int i,int j){
        char temp;
        temp = c[i];
        c[i] = c[j];
        c[j] = temp;
    }

}
