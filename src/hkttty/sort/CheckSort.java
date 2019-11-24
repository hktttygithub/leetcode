package hkttty.sort;

import java.util.Arrays;

public class CheckSort {
    public static boolean check(int []arr,int []old){
        Arrays.sort(old);
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]!=old[i]){
                System.out.print("fuck!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                return false;
            }
        }
        System.out.print("true      ");
        return true;
    }
}
