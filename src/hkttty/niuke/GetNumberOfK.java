package hkttty.niuke;

import org.junit.Test;

public class GetNumberOfK {
    public int getNumberOfK(int[] arr, int k) {
        if(arr.length==0){
            return 0;
        }
        int left = 0;
        int right = arr.length - 1;
        int leftIndex = findLeft(arr, left, right, k);
        if (leftIndex == -1) {
            return 0;
        }
        int rightIndex = findRight(arr, leftIndex, right, k);
        return rightIndex - leftIndex + 1;
    }

    int findLeft(int[] arr, int left, int right, int target) {
        while (left < right) {
            int mid =  (left+ right) >> 1;
            if (target > arr[mid]) {
                left = mid + 1;
            } else if (target < arr[mid]) {
                right = mid;
            } else {
                //target==arr[mid]
                if (mid - 1 >= 0 && arr[mid - 1] != arr[mid] || mid == 0) {
                    return mid;
                } else {
                    right = mid;
                }
            }
        }
        return arr[left] == target ? left : -1;
    }

    int findRight(int[] arr, int left, int right, int target) {
        while (left < right) {
            int mid = (left+ right) >> 1;
            if (target > arr[mid]) {
                left = mid + 1;
            } else if (target < arr[mid]) {
                right = mid;
            } else {
                //target==arr[mid]
                if (mid + 1 < arr.length && arr[mid + 1] != arr[mid] || mid == arr.length - 1) {
                    return mid;
                } else {
                    left = mid + 1;
                }
            }
        }
        return arr[left] == target ? left : -1;
    }

    @Test
    public void test1(){
        //[3,3,3,3,4,5],3
        int []arr = new int[]{3,3,3,3,4,5};
        int numberOfK = getNumberOfK(arr, 3);
        System.out.println(numberOfK);

//        String s = "2";
        int a = 10;
        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toBinaryString(-a));
        System.out.println(Integer.toBinaryString(a&(-a)));
    }
}
