package hkttty.niuke;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MinK2 {
    //最大堆
    PriorityQueue<Integer> queue = new PriorityQueue<Integer>(50,
            (Integer i1,Integer i2)->i2 - i1);
    ArrayList<Integer> res = new ArrayList<>();

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if(input==null || k >input.length || k<=0){
            return res;
        }
//        int minLength = input.length < 10 ? input.length : 10;
        for(int i=0;i<k;i++){
            queue.add(input[i]);
        }
        for (int i=k;i<input.length;i++){
            if(input[i] < queue.peek()){
                queue.poll();
                queue.add(input[i]);
            }
        }
        while (!queue.isEmpty()){
            res.add(queue.poll());
        }
        return res;
    }

}
