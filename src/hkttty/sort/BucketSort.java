package hkttty.sort;

import org.junit.Test;

public class BucketSort {
    @Test
    public void test1(){
        int[] randomArray = RandomArray.getRandomArray(100, 100);
        bucketSort(randomArray);
    }

    void bucketSort(int []arr){
        //arr数组中值的范围必须是0到arr.length；
        int []help = new int [arr.length+1];
        for (int i = 0; i < arr.length; i++) {
            help[arr[i]]++;
        }
        for (int i = 0; i < help.length; i++) {
            while ((help[i]--)>0){
                System.out.print(i + " ");
            }
        }
    }
}
