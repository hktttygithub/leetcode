package hkttty.jian.page1;

import org.junit.Test;

public class LeetCode_74 {

    public boolean searchMatrix(int target, int [][] array) {
        if(array.length==0 || array[0].length==0){
            return false;
        }
        int row = array.length-1;
        int col = array[0].length-1;
        int left = 0;
        int right = row;
        while(left<right){
            int mid = (left + right) /2;
            if(target >= array[mid][0] &&  target<array[mid+1][0]){
                return findNumber(0,col,array[mid],target);
            }else if(target <array[mid][0]){
                right = mid;
            }else{
                // target >= arr[mid+1][0]
                left = mid + 1;
            }
        }
        return findNumber(0,col,array[left],target);
    }

    private boolean findNumber(int left, int right, int[] arr,int target) {
        while(left<right){
            int mid  = (left + right) /2;
            if(target>arr[mid]){
                left = mid + 1;
            }else if(target<arr[mid]){
                right = mid;
            }else{
                return true;
            }
        }
        return  target==arr[left];
    }

    @Test
    public void test1(){
        int [][]arr = new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        boolean b = searchMatrix(3, arr);
        System.out.println(b);
    }
}
