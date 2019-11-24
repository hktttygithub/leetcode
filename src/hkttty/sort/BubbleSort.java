package hkttty.sort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] array = SelectSort.randomArray(100, 100);
        int[] arr1 = array.clone();
        int[] arr2 = array.clone();
        test1(arr1);
        SelectSort.selectSort(arr2);

        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(arr1).equals(Arrays.toString(arr2)));
    }

    private static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] < arr[j - 1]) {
                    SelectSort.swap(arr, j, j - 1);
                }
            }
        }
    }

    public  static void test1(int []arr){
        for(int i=0;i<arr.length;i++){
            for(int j=1;j<arr.length-i;j++){
                if(arr[j]<arr[j-1]){
                    arr[j] = arr[j-1] ^ arr[j];
                    arr[j-1]  = arr[j-1] ^ arr[j];
                    arr[j]  = arr[j-1] ^ arr[j];
                }
            }
        }
    }


}
