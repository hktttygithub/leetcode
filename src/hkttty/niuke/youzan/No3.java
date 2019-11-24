package hkttty.niuke.youzan;

import java.util.Arrays;
import java.util.Scanner;

public class No3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String substring = s.substring(1, s.length() - 1);
        String[] s1 = substring.split(",");
        int []arr = new int[s1.length];
        for (int i = 0; i < s1.length; i++) {
            arr[i] = Integer.valueOf(s1[i]);
        }


        int l=0;
        int r =arr.length-1;
        while (true){
            int[] parttion = parttion(arr, 0, arr.length - 1);
            if(parttion[0]<=3 && parttion[1]>=3){
                System.out.println(arr[3]);
                break;
            }else{
                if(parttion[0]>3){
                    r = parttion[0]-1;
                }else {
                    l = parttion[1] +1;
                }
            }
        }

//        Arrays.sort(arr);
//        System.out.println(arr[2]);
    }

    private static int[] parttion(int[] arr, int l, int r) {
        int less = l - 1;
        int more = r;
        while (l < more) {
            if (arr[l] < arr[r]) {
                swap(arr, ++less, l++);
            } else if (arr[l] > arr[r]) {
                swap(arr, --more, l);
            } else {
                l++;
            }
        }
        swap(arr, more, r);
        return new int[]{less + 1, more};

    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
