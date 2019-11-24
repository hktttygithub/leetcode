package hkttty.jian.page1;

public class No11 {
    //题目描述
    //输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
    public int NumberOf1(int n) {
        int sum = 0;
        int flag = 1;
        for(int i=0;i<32;i++){
            if((flag & n)!=0){
                sum++;
            }
            flag = flag<<1;
        }
        return sum;
    }
}
