package hkttty.niuke;

import org.junit.Test;

public class YiBan {
    int mid;
    int findNumber=0;
    boolean flag = false;

    public int MoreThanHalfNum_Solution(int [] array) {
        if(array==null || array.length==0){
            return 0;
        }
        mid = array.length>>1;
        if(array.length==1){
            return array[0];
        }
        find(array,0,array.length-1);
        if(flag){
            int times = 0;
            for(int i : array){
                if(i==findNumber){
                    times++;
                }
            }
            if((times<<1) >= array.length){
                return findNumber;
            }
        }
        return 0;
    }

    void find(int [] array,int l,int r){
        if(l<r){
            int []p = partition(array,l,r);
            if(p[0]<=mid && p[1]>=mid){
                flag = true;
                findNumber = array[p[0]];
                return;
            }else if(p[0]>mid){
                find(array,l,p[0]-1);
            }else{
                find(array,p[1]+1,r);
            }
        }
        return;
    }

    private int[] partition(int []arr,int l,int r){
        int less = l-1;
        int more = r;
        while(l<more){
            if(arr[l]<arr[r]){
                swap(arr,++less,l++);
            }else if(arr[l]>arr[r]){
                swap(arr,--more,l);
            }else{
                l++;
            }
        }
        swap(arr,more,r);
        return new int[]{less+1,more};
    }

    private void swap(int []arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    @Test
    public void test1(){
        //[1,2,3,2,2,2,5,4,2]
        //用例:
        //[2,2,2,2,2,1,3,4,5]
        int [] arr = new int[]{2,2,2,2,2,1,3,4,5};
        int i = MoreThanHalfNum_Solution(arr);
        System.out.println(i);
    }
}
