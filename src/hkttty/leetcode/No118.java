package hkttty.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class No118 {
    @Test
    public void test1(){
        generate(5);
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> preList = new ArrayList<>();
        preList.add(1);
        list.add(preList);
        if(numRows==1){
            return list;
        }
        preList = new ArrayList<>();
        preList.add(1);
        preList.add(1);
        list.add(preList);
        if(numRows==2){
            return list;
        }
        for(int i=3;i<=numRows;i++){
            List<Integer> curList = new ArrayList<>();
            curList.add(1);
            for(int j=1;j<preList.size();j++){
                curList.add(preList.get(j-1) + preList.get(j));
            }
            curList.add(1);
            list.add(curList);
            preList = curList;
        }
        return list;
    }
}
