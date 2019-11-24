package hkttty.niuke;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class ShuJuLiu {
    PriorityQueue<Integer> bQueue = new PriorityQueue<Integer>((Integer i1,Integer i2)-> i2-i1);
    PriorityQueue<Integer> mQueue = new PriorityQueue<Integer>((Integer i1,Integer i2)-> i1-i2);

    //两种情况
    //1.最大堆的的数量比最小堆多1个
    //2.最大堆和最小堆的数量相同
    //其他情况都要进行调整

    public void Insert(Integer num) {
       if(bQueue.size()==0 || num<bQueue.peek()){
           bQueue.add(num);
       }else {
           mQueue.add(num);
       }
       if(bQueue.size() == mQueue.size()+2){
           mQueue.add(bQueue.poll());
       }
       if(bQueue.size() + 1 == mQueue.size()){
           bQueue.add(mQueue.poll());
       }
    }

    public Double GetMedian() {
        if(mQueue.size()==bQueue.size()){
            return (1.0 * mQueue.peek() + bQueue.peek())/2;
        }
        return 1.0 * bQueue.peek();
    }

    public static void main(String[] args) {
        ShuJuLiu shuJuLiu = new ShuJuLiu();
        shuJuLiu.Insert(5);
        System.out.println(shuJuLiu.GetMedian());
        shuJuLiu.Insert(2);
        System.out.println(shuJuLiu.GetMedian());
        shuJuLiu.Insert(3);
        System.out.println(shuJuLiu.GetMedian());
        shuJuLiu.Insert(4);
        System.out.println(shuJuLiu.GetMedian());
        shuJuLiu.Insert(1);
        shuJuLiu.Insert(6);
        shuJuLiu.Insert(7);
    }

}
