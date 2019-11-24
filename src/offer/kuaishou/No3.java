package offer.kuaishou;

import java.util.Scanner;

public class No3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int []arr = new int[scanner.nextInt()];
        int sum=0;
        for(int i=0;i<arr.length;i++){
            arr[i] = scanner.nextInt();
            sum += arr[i];
        }
        if(arr.length==1){
            System.out.println();
            return;
        }
        int go = go(arr, sum);
        System.out.println(go);
    }

    static int go(int []arr,int sum){
        //两个滑动窗口
        int left1 = 0;
        int left2 = 1;
        int sum1 = arr[0];
        int sum2 = sum - arr[0];
        int min = Integer.MAX_VALUE;
        while(left2!=arr.length){
            if(Math.abs(sum1-sum2)<min){
                min = Math.abs(sum1-sum2);
            }
            sum2 = sum2 - arr[left2];
            sum1 = sum1 + arr[left2];
            left1 = left2;
            left2++;
        }
        return min;
    }


}
