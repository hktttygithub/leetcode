package hkttty.niuke;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SumS {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res =
                new ArrayList<>();
        if (sum <= 2) {
            return res;
        }
        int left = 1;
        int right = 1;
        while(right<sum){
            int temp = (left + right) * (right - left+1) /2 ;
            if(temp==sum){
                ArrayList list = new ArrayList();
                for (int i = left; i <=right ; i++) {
                    list.add(i);
                }
                res.add(list);
                right++;
            }else if(temp<sum){
                right++;
            }else{
                left++;
            }
        }
        return res;
    }

    @Test
    public void test1(){
        ArrayList<ArrayList<Integer>> arrayLists = FindContinuousSequence(9);
        String s = arrayLists.toString();
        System.out.println(s);
    }

    public ArrayList<ArrayList<Integer> > FindContinuousSequence2(int sum) {
        //存放结果
        ArrayList<ArrayList<Integer> > result = new ArrayList<>();
        //两个起点，相当于动态窗口的两边，根据其窗口内的值的和来确定窗口的位置和大小
        int plow = 1,phigh = 2;
        while(phigh <sum){
            //由于是连续的，差为1的一个序列，那么求和公式是(a0+an)*n/2
            int cur = (phigh + plow) * (phigh - plow + 1) / 2;
            //相等，那么就将窗口范围的所有数添加进结果集
            if(cur == sum){
                ArrayList<Integer> list = new ArrayList<>();
                for(int i=plow;i<=phigh;i++){
                    list.add(i);
                }
                result.add(list);
                plow++;
                //如果当前窗口内的值之和小于sum，那么右边窗口右移一下
            }else if(cur < sum){
                phigh++;
            }else{
                //如果当前窗口内的值之和大于sum，那么左边窗口右移一下
                plow++;
            }
        }
        return result;
    }
}
