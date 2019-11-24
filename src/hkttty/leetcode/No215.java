package hkttty.leetcode;

public class No215 {
    //数组中第k大的元素
    public int findKthLargest(int[] nums, int k) {
        if(nums==null || nums.length<k || k<=0){
            return -1;
        }
        k = nums.length - k;
        int l=0;
        int r=nums.length-1;
        while (true){
            int[] partition = partition(nums, l,r);
            if(k>=partition[0] && k<=partition[1]){
                return nums[k];
            }else{
                if(k<partition[0]){
                    r=partition[0]-1;
                }else{
                    l=partition[1]+1;
                }
            }
        }
    }



    int[] partition(int []arr,int l,int r){
//        int random = Math.random()
        swap(arr, l + (int) (Math.random() * (r - l + 1)), r);
        int less = l-1;
        int more = r;
        while (l<more){
            if(arr[l]<arr[r]){
                swap(arr,++less,l++);
            }else if(arr[l]>arr[r]){
                swap(arr,--more,l);
            }else{
                l++;
            }
        }
        swap(arr,r,more);
        return new int[]{less+1,more};
    }

    void swap(int[]arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
