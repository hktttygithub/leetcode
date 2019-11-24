package hkttty.sort;

import org.junit.Test;

import java.util.Arrays;

public class MergeSort {
    @Test
    public void test1(){
        int[] randomArray = RandomArray.getRandomArray(100, 100);
        int [] test = randomArray.clone();
        merge(randomArray);
        Arrays.sort(test);
        System.out.println(Arrays.toString(test).equals(Arrays.toString(randomArray)));
        System.out.println(Arrays.toString(test));
        System.out.println(Arrays.toString(randomArray));
    }

    void merge(int []arr){
        if(arr == null || arr.length<2){
            return;
        }
        mergeSort(arr,0,arr.length-1);
    }

    private void mergeSort(int[] arr,int l,int r) {
        if(l==r){
            return;
        }
        int mid = (l+r)/2;
        mergeSort(arr,l,mid);
        mergeSort(arr,mid+1,r);
        merge2(arr,l,mid,r);
    }

    private void merge2(int[] arr, int l, int mid, int r) {
        int []help = new int [r-l+1];
        int left = l;
        int right = mid+1;
        int i=0;
        while(left<=mid && right<=r){
            help[i++] = arr[left] < arr[right] ? arr[left++] : arr[right++];
        }
        while(left<=mid){
            help[i++] = arr[left++];
        }
        while (right<=r){
            help[i++] = arr[right++];
        }
        i=0;
        while(i<help.length){
            arr[l+i] = help[i];
            i++;
        }
    }
}
