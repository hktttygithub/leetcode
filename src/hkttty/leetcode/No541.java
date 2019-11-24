package hkttty.leetcode;

public class No541 {
    public String reverseStr(String s, int k) {
        int l = s.length();
        int i=0;
        char []c = s.toCharArray();
        for(;i<l-2*k;i=i+2*k){
            reverse(c,i,k-1);
        }
        if(i<l-k){
            reverse(c,i,l-1);
        }else if(i>=l-k){
            reverse(c,i,i+k-1);
        }
        return new String(c);

    }

    void reverse(char []c,int start,int end){
        while(start<end){
            char temp = c[start];
            c[start] = c[end];
            c[end] = temp;
            start++;
            end--;
        }
    }
}
