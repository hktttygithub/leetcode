package hkttty.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class No210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(prerequisites.length==0 || prerequisites[0].length==0){
            int []arr = new int[numCourses];
            for(int i=0;i<numCourses;i++){
                arr[i] = i;
            }
            return arr;
        }
        HashMap<Integer, ArrayList<Integer>> nextsMap = new HashMap<>();
        HashMap<Integer, Integer> inMap = new HashMap<>();
        for (int[] arr : prerequisites) {
            //arr[0] : to
            //arr[1] : from
            if (!nextsMap.containsKey(arr[1])) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(arr[0]);
                nextsMap.put(arr[1],list);
            } else {
                ArrayList<Integer> list = nextsMap.get(arr[1]);
                list.add(arr[0]);
            }
            if (!inMap.containsKey(arr[0])) {
                inMap.put(arr[0], 1);
            } else {
                inMap.put(arr[0], inMap.get(arr[0]) + 1);
            }
        }
        int index = 0;
        int[] res = new int[numCourses];
        int size = numCourses;
        for (int i = 0; i < size; i++) {
            if (inMap.get(i) == null) {
                inMap.put(i, 0);
                LinkedList<Integer> queue = new LinkedList<>();
                queue.add(i);
                while (!queue.isEmpty()) {
                    Integer poll = queue.poll();
                    ArrayList<Integer> nexts = nextsMap.get(poll);
                    numCourses--;
                    res[index++] = poll;
                    if (nexts != null) {
                        for (Integer next : nexts) {
                            inMap.put(next, inMap.get(next) - 1);
                            if (inMap.get(next) == 0) {
                                queue.add(next);
                            }
                        }
                    }
                }
            }
        }
        return numCourses==0 ? res : new int[0];
    }

    @Test
    public void test1(){
        int [][]arr = new int[][]{{1,0}};
        int[] order = findOrder(3, arr);
        for(int[] a : arr){
            System.out.println(Arrays.toString(order));
        }
    }
}
