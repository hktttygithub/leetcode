package hkttty.offer;

import org.junit.Test;

//数组中重复的数组（不可以修改原数组）
//并且重复的数字可能不止一个
//不用空间复杂度为0(n)的算法实现
//只需要找出任意一个重复
public class No2 {
    //数组的长度为n+1，且所有数字都在1到n的范围内，则必有重复
    //用二分法

    @Test
    public void test3() {
        System.out.print("test3：");
        int[] a = { 1, 2, 3, 2, 4 };
        int dup = method1(a,a.length);
        if (dup >= 0)
            System.out.println("重复数字为：" + dup);
    }


    Integer method1(int []arr,int length){
        if (arr==null || arr.length<2){
            return null;
        }
        int start = 1;
        int end = length-1;
        while(end>=start){
            int middle = ((end-start)>>1)+start;
            int count = countRange(arr,length,start,middle);
            if(end==start){
                if (count>1)
                    return start;
                else
                    break;
            }
            if(count>(middle-start)+1){
                end = middle;
            }else{
                start = middle+1;
            }
        }

        return null;
    }

    private int countRange(int[] arr, int length, int start, int end) {
        if(arr==null){
            return -1;
        }
        int count = 0;
        for (int i = 0; i < length; i++) {
            if(arr[i]>=start && arr[i]<=end)
                ++count;
        }
        return count;
    }
}
