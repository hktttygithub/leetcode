package offer.bilibili;

import java.util.LinkedList;
import java.util.Scanner;

//滑动窗口
public class No2 {
    static int []arr;
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n<=0){
            System.out.println(0);
            return;
        }
        find(n);
        System.out.println(count);
    }

    private static void find(int n) {
        int left = 1;
        int right = 1;
        int tempSum = 1;
        while (right<=n){
            if(tempSum<n){
                right++;
                tempSum = tempSum + right;
            }else if(tempSum>n){
                tempSum = tempSum - left;
                left++;
            }else{
//                System.out.println(left + "   " +  right);
                //xiang deng
                count++;
                right++;
                tempSum = tempSum + right;
            }
        }
    }
}
