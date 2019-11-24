package hkttty.offer;

import org.junit.Test;

import java.util.HashSet;

//p39 数组中重复的数字
//重复的数字只有一个
public class No1 {
    @Test
    public void test1(){
        int [] arr = new int[]{3,1,2,6,2,5,4};
        Integer integer = method4(arr);
        System.out.println(integer);
    }

    //用哈希表
    //空间复杂度 0(n) 时间复杂度O(n)
    Integer method1(int []arr){
        if(arr==null || arr.length<2){
            return null;
        }
        HashSet<Integer> set = new HashSet<>();
        int n=0;
        while (n <arr.length){
            if(set.add(arr[n])){
                return arr[n];
            }
        }
        return null;
    }

    //用桶排序的思想
    //空间复杂度 0(n) 时间复杂度O(n)
    Integer method2(int []arr) {
        int [] bucket = new int[arr.length-1];
        for (int i =0;i<arr.length;i++){
            bucket[arr[i]]++;
            if(bucket[arr[i]]==2){
                return arr[i];
            }
        }
        return null;
    }

    /*
    * 也用到了hash的思想(其实桶排序也是吧）
    * 把arr[i]的元素，存到i位置上，如果有重复的数，那必然会有两个相同的值都存到i位置
    * 时间复杂度0(n)，空间复杂度0(1)
    * */
    Integer method3(int []arr){
        for (int i = 0 ; i<arr.length;i++) {
            while (arr[i] != i) {
                if (arr[i] == arr[arr[i]]) {
                    return arr[i];
                }
                swap(arr, i, arr[i]);
            }
        }
        return null;
    }

    Integer method4(int []arr){
        int a=0;
        for (int i = 0; i < arr.length; i++) {
            a ^= arr[i];
        }
        for (int i = 0; i < arr.length; i++) {
            a = a^i;
        }
        return a;
    }

    void swap(int[]arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
