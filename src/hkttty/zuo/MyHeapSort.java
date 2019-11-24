package hkttty.zuo;

import hkttty.leetcode.No215_3;

import static hkttty.zuo.Code_03_HeapSort.*;
import static hkttty.zuo.Code_03_HeapSort.generateRandomArray;
import static hkttty.zuo.Code_03_HeapSort.printArray;

public class MyHeapSort {



    public int findKthLargest(int[] input, int k) {
        heapSort(input);
        return input[input.length-k];

    }

    void heapSort(int []nums){
        if(nums==null || nums.length<2){
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            heapInsert(nums,i);
        }
        int size = nums.length-1;
        while (size>0){
            swap(nums,size--,0);
            heapify(nums,0,size);
        }

    }

    //最大堆
    void heapInsert(int []nums,int index){
        while (index>0){
            if (nums[index]>nums[(index-1)/2]){
                swap(nums,index,(index-1)/2);
                index  = (index-1)/2;
            }else{
                return;
            }
        }
    }

    //调整最大堆
    void heapify(int []nums,int index,int size){
        int left = index * 2 + 1;
        while (left <= size){
            int bigIndex = left + 1 <=size && nums[left+1] > nums[left] ?  left+1 : left;
            if(nums[index] > nums[bigIndex]){
                return;
            }else {
                swap(nums,bigIndex,index);
                index = bigIndex;
                left = index*2 + 1;
            }
        }
    }
    private void swap(int[] nums, int j, int i) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        MyHeapSort test = new MyHeapSort();
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            test.heapSort(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
        test.heapSort(arr);
        printArray(arr);
    }
}
