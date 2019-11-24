package hkttty.niuke._360;

import java.util.Scanner;

public class No3 {
    static Scanner sc = new Scanner(System.in);
    static int max=0;
    public static void main(String[] args) {

        int n = sc.nextInt();
        while (n>0){
           go();
        }
    }

    private static void go() {
        max = 0;
        int []arr = new int[3];
        for(int i=0;i<3;i++){
            arr[i] = sc.nextInt();
        }
        helper(arr,0,0,0);
    }

    private static void helper(int[] arr,int fir,int sec,int thir) {
        for(int i=0;i<arr.length;i++){
            if(i==0){
                helper(arr,fir+1,sec,thir);
            }else if(i==1){
                helper(arr,fir,sec+1,thir);
            }else if(i==2) {
                helper(arr,fir,sec,thir+1);
            }
        }
    }
}
