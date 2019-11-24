package hkttty.sort;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int []arr  =  SelectSort.randomArray(1000,500);
        test1(arr);
        System.out.println(Arrays.toString(arr));

        int i = 0;
        for(;i<=0 ;i++){
            System.out.println(i);
        }
    }

    private static void insertSort(int[] arr) {
        if(arr==null || arr.length<2){
            return;
        }
        for(int i =1 ;i<arr.length;i++){
            for(int j=i-1;j>=0 && arr[j]> arr[j+1];j--){
                SelectSort.swap(arr,j,j+1);
            }
        }

    }


    public static void test1(int []arr){
        for(int i=1;i<arr.length;i++){
            for(int j=i;j>0 && arr[j]<arr[j-1];j--){
               SelectSort.swap(arr,j,j-1);
            }
        }
    }
}
