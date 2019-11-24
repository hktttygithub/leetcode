package hkttty.leetcode;

import org.junit.Test;

public class No673 {
    public int findNumberOfLIS(int[] nums) {
        if(nums==null || nums.length<=0){
            return 0;
        }
        int []dpL = new int[nums.length]; //长度
        int []dpT = new int[nums.length]; //出现次数
        for(int i=0;i<nums.length;i++){
            dpL[i] =1;
            dpT[i] =1;
        }
        for(int i=1;i<nums.length;i++){
            int tempL = 0;
            int tempT = 0;
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    if(tempL==dpL[j]){
                        tempT = tempT + dpT[j];
                    }else if(tempL<dpL[j]){
                        tempL = dpL[j];
                        tempT = dpT[j];
                    }
                }
            }
            tempT = (tempT == 0) ? 1 : tempT;
            dpL[i] = tempL +1;
            dpT[i] = tempT;
        }
        int count=0;
        int maxLength=0;
        for(int i=0;i<nums.length;i++){
            if(dpL[i]>maxLength){
                maxLength =dpL[i];
                count = dpT[i];
            }else if(dpL[i]==maxLength){
                count = count + dpT[i];
            }
        }
        return count;
    }

    @Test
    public void test1(){
        int []arr = new int[]{2,2,2,2,2};
        int numberOfLIS = findNumberOfLIS(arr);
    }
}
