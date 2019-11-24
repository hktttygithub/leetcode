package hkttty.sort;

import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        int []arr = randomArray(100,100);
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] randomArray(int length, int max) {
        int [] arr = new int [length];
        for (int i = 0; i < length; i++) {
            arr[i] = (int)(Math.random()*max)+1;
        }
        return arr;
    }

    public static void selectSort(int []arr){

        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for(int j=i+1;j<arr.length;j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            if(i!=min){
                swap(arr,i,min);
            }
        }
    }

    private void test1(int []arr){
        for(int i=0;i<arr.length;i++){
            int min = i;
            for(int j=i;j<arr.length;j++){
                if(arr[j] < arr[min]){
                    min = j;
                }
            }
            swap(arr,i,min);
        }
    }

    public  static  void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
