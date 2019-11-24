package hkttty.niuke;

import java.util.Arrays;

public class PuKe {
    public boolean isContinuous(int [] numbers) {
        if(numbers==null || numbers.length<=0){
            return false;
        }
        int zeroCount = 0;
        int sum=0;
        Arrays.sort(numbers);
        for(int i=0;i<numbers.length-1;i++){
            if(numbers[i]==0){
                zeroCount++;
            }else{
                sum += numbers[i+1] - numbers[i] -1 ;
            }
        }
        if(sum<=zeroCount){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
