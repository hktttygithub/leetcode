package hkttty.sort;

import org.junit.Test;

import java.util.Arrays;

public class QucikSort {

    /*  先解决
     *  类似荷兰国旗问题：
     *  现在数组中有一个数num，
     *  需要把小于num的数放在num的左边
     *  等于num的数放数组中间
     *  大于num的数放num右边
     * */
    public static void partiton(int[] arr, int l, int r,int num) {
        int left = l - 1;
        int right = r + 1;
        int index=0;
        while(index<right){
            if(arr[index]<num){
                arr=swap(arr,index++,++left);
            }else if(arr[index]==num){
                index++;
            }else{ // arr[index]>num
                arr=swap(arr,index,--right);
            }
        }
        if(check(arr,num)){
            System.out.println("yes");
            System.out.println(Arrays.toString(arr));
            System.out.println(num);
        }else {
            System.out.println("no");
            System.out.println(Arrays.toString(arr));
            System.out.println(num);
        }
    }

    //检查是否正确
    public static boolean check(int[] arr,int num) {
        int start=0;
        int end=0;
        for(int i=0;i<arr.length;i++){
            if(num==arr[i]){
                start=i;
                break;
            }
        }
        for(int i=arr.length-1;i>=0;i--){
            if(num==arr[i]){
                end=i;
                break;
            }
        }
        System.out.println("s:" + start);
        System.out.println("e:" + end);
        int index=0;
        while(index<start){
            if(arr[index]>=arr[start])
                return false;
            index++;
        }
        index=arr.length-1;
        while(index<start){
            if(arr[index]<=arr[start])
                return false;
        }
        for (int i =start; i <=end ; i++) {
            if(arr[i]!=arr[start]){
                return false;
            }
        }

        return true;

    }

    private static int [] swap(int[]arr,int index1,int index2){
        int temp = arr[index1];
        arr [index1] = arr[index2];
        arr [index2] = temp;

        return arr;
    }

    @Test
    public void test() {
        int arr[] = RandomArray.getRandomArray(1000, 100);
//        System.out.println(Arrays.toString(arr));
        partiton(arr, 0, arr.length - 1,arr[0]);

    }




}
