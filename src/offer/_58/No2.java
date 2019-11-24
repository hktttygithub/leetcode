package offer._58;

import java.util.Scanner;

public class No2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []arr = new int[n];
        int []bin = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
            bin[i] = 1;
        }

        if (arr[0]<arr[1]){
            arr[0] = 1;
        }else{
            arr[0] = 2;
        }
        int sum = bin[0];
        for(int i=1;i<arr.length-1;i++){
            if(arr[i]<=arr[i-1] && arr[i]<=arr[i+1]){
                bin[i] = 1;
            }else if(arr[i]>arr[i-1]){
                bin[i] = bin[i-1] + 1;
            }else{
                bin[i] = 2;
            }
//            System.out.println( "i=" + i + " " + bin[i]); //test
            sum += bin[i];
        }
        if(arr[arr.length-1]<arr[arr.length-2]){
            bin[arr.length-1] = 1;
        }else{
            bin[arr.length-1] = arr[arr.length-2] + 1;
        }
        sum += bin[arr.length-1];
        System.out.println(sum);
        //arr[i]
    }
}
