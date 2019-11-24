package hkttty.leetcode;

import org.junit.Test;

public class No461 {
    @Test
    public void test1(){
        int i = hammingDistance(0, 1);
        System.out.println(i);
    }

    public int hammingDistance(int x, int y) {
        if(x==y){
            return 0;
        }
        int flag = 1;
        int index1 = -1;
        int index2 = -1;
        for(int i =0 ; i<32 ;i++){
            if((((flag & x) ==0) && ((flag & y) != 0))
                    ||((flag & x) !=0) && ((flag & y) == 0) ){
                if(index1==-1){
                    index1 = i;
                }else{
                    index2 = i;
                    break;
                }
            }
            flag = flag << 1;
        }

        return index2 - index1;
    }
}
