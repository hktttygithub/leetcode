package offer;

import java.util.Arrays;

import static hkttty.zuo.Code_04_QuickSort.*;
import static hkttty.zuo.Code_04_QuickSort.printArray;

/**
 * 快速排序：通过一趟排序将待排序记录分割成独立的两部分，其中一部分记录的关键字均比另一部分关键字小，则分别
 * 对这两部分继续进行排序，直到整个序列有序。
 *
 * @author BaoZi
 * @create 2019-05-15-18:15
 */
public class QuickSort {
    public static void main(String[] args) {
        final int MAX = 15;
        int[] nums = new int[MAX];
        System.out.println("...............使用的是选择排序算法...............");
        for (int i = 0; i < MAX; i++) {
            nums[i] = (int) (Math.random() * 51);
        }
        System.out.println("排序之前的数组为...............");
        System.out.println(Arrays.toString(nums));

        //使用选择排序算法进行排序：
        QuickSort sort = new QuickSort();
        sort.quickSort(nums, 0, nums.length - 1);
        System.out.println("排序之后的数组为...............");
        System.out.println(Arrays.toString(nums));
    }

    public void quickSort(int[] nums, int low, int high) {
        if (low < high) {
            int middle = getMiddle(nums, low, high);
            printArr(nums);
            //对左子序列进行排序
            quickSort(nums, low, middle - 1);
            //对右子序列进行排序
            quickSort(nums, middle + 1, high);
        }
    }

    private void printArr(int[] nums) {
        for (int i : nums) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private int getMiddle(int[] nums, int low, int high) {
        //当前数组的第一个元素作为中轴（基准）
        int temp = nums[low];
        while (low < high) {
            while (low < high && nums[high] >= temp) {
                high--;
            }
            swap(nums, low, high);
            while (low<high && nums[low] <= temp){
                low++;
            }
            swap(nums,low,high);
        }
        return low;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

//    public static void main(String[] args) {
//        QuickSort test = new QuickSort();
//        int testTime = 500000;
//        int maxSize = 100;
//        int maxValue = 100;
//        boolean succeed = true;
//        for (int i = 0; i < testTime; i++) {
//            int[] arr1 = generateRandomArray(maxSize, maxValue);
//            int[] arr2 = copyArray(arr1);
//            test.quickSort(arr1,0,arr1.length-1);
////            new QucikSort3().sort(arr1);
//            comparator(arr2);
//            if (!isEqual(arr1, arr2)) {
//                succeed = false;
//                printArray(arr1);
//                printArray(arr2);
//                break;
//            }
//        }
//        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
//
//        int[] arr = generateRandomArray(maxSize, maxValue);
//        printArray(arr);
//        test.quickSort(arr,0,arr.length-1);
//        printArray(arr);
//
//    }
}