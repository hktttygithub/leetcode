package hkttty.sort;

import org.junit.Test;

public class QucikSort3 {

    @Test
    public void test1(){
        for (int i = 0; i < 100; i++) {
            int[] randomArray = RandomArray.getRandomArray(10000, 10000);
            int[] clone = randomArray.clone();
            sort(randomArray);
            CheckSort.check(randomArray,clone);
        }

    }

    void sort(int[]arr){
        sort(arr,0,arr.length-1);
    }

    void sort(int []arr,int l,int r){
        if(l<r){
            int [] p =partition(arr,l,r);
            sort(arr,l,p[0]-1);
            sort(arr,p[1]+1,r);

        }
    }

    int[] partition(int[] arr, int l, int r) {
        int less = l - 1;
        int more = r;
        while (l < more) {
            if (arr[l] < arr[r]) {
                swap(arr, ++less, l++);
            }else if(arr[l]>arr[r]){
                swap(arr,--more,l);
            }else {
                l++;
            }
        }
        swap(arr,r,more);
        return new int[]{less+1,more};
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
