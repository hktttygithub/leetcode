package hkttty.offer;

import org.junit.Test;

import java.util.Arrays;

//二维数组中的查找
//p44
public class No4_Find {
    @Test
    public void test1(){
        int a[][]={{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        int a2[][]={{}};
        System.out.println(Arrays.toString(a2[0]));
        System.out.println(Arrays.toString(a[0]));
        System.out.println(a2.length);
        System.out.println(a2[0].length);
        Boolean aBoolean = find(a, 5);
        Boolean aBoolean2 = find(a2, 1);
        System.out.println(aBoolean);
    }

    Boolean find(int [][]arr,int findNumber){
        if(arr==null || arr.length<1 || arr[0].length<1){
            return false;
        }
        int row = arr.length;
        int col = row;
        int i = 0;
        int j = row -1 ;
        while(i<row && j>=0){
            if(findNumber==arr[i][j]){
                return true;
            }else if(findNumber>arr[i][j]){
                ++i;
            }else{
                --j;
            }
        }

        return false;
    }
}
