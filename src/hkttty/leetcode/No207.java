package hkttty.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class No207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, ArrayList<Integer>> nexts = new HashMap<>();//邻居结点
        HashMap<Integer, Integer> in = new HashMap<>();//入度
        for (int[] arr : prerequisites) {
            //arr[0]代表to，arr[1]代表from
            ArrayList<Integer> nextsList = nexts.containsKey(arr[1]) ? nexts.get(arr[1]) : new ArrayList<>();
            nextsList.add(arr[0]);
            nexts.put(arr[1],nextsList);
            int inCount = 1 + (in.containsKey(arr[0]) ? in.get(arr[0]) : 0);
            in.put(arr[0], inCount);
        }
        //拓扑排序
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (in.get(i) == null) {
                in.put(i, 0);
                queue.addLast(i);
            }
        }
        while (!queue.isEmpty()) {
            Integer poll = queue.pollFirst();
            numCourses--;
            ArrayList<Integer> nextsList = nexts.get(poll);
            if(nextsList==null){
                continue;
            }
            for(Integer next : nextsList){
                in.put(next,in.get(next)-1);
                if(in.get(next)==0){
                    queue.add(next);
                }
            }
        }

        return numCourses == 0;
    }

    @Test
    public void test1(){
        int [][]arr = new int[][]{{1,0},{2,1},{1,2}};
        boolean b = canFinish(2, arr);
        System.out.println(b);
    }

}
