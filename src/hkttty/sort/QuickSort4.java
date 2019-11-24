package hkttty.sort;

import static hkttty.zuo.Code_04_QuickSort.*;

public class QuickSort4 {

    static void sort(int[] nums){
        if(nums==null || nums.length<2){
            return;
        }
        sort1(nums,0,nums.length-1);
    }

    private static void sort1(int[] nums, int left, int right) {
        if(left<right){
            int []p = partition(nums,left,right);
            sort1(nums,left,p[0]-1);
            sort1(nums,p[1]+1,right);
        }
    }

    static int[] partition(int[] nums, int l, int r){
//        swap(nums,r,l+(int)Math.random()*(r-l));
        int less =l-1;
        int more = r;
        while (l<more){
            if(nums[l]<nums[r]){
                swap(nums,++less,l++);
            }else if(nums[l]> nums[r]){
                swap(nums,--more,l);
            }else{
                l++;
            }
        }
        swap(nums,r,more);
        return new int[]{less+1,more};
    }

    static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // for test
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            sort(arr1);
//            new QucikSort3().sort(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
        quickSort(arr);
        printArray(arr);

    }
}
