package hkttty.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class No207_DFS {
    HashMap<Integer, ArrayList<Integer>> nexts;
    HashMap<Integer, Integer> in;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        nexts = new HashMap<>();//邻居结点
        in = new HashMap<>();//入度
        for (int[] arr : prerequisites) {
            //arr[0]代表to，arr[1]代表from
            ArrayList<Integer> nextsList = nexts.containsKey(arr[1]) ? nexts.get(arr[1]) : new ArrayList<>();
            nextsList.add(arr[0]);
            nexts.put(arr[1],nextsList);
            int inCount = 1 + (in.containsKey(arr[0]) ? in.get(arr[0]) : 0);
            in.put(arr[0], inCount);
        }
        for (int i = 0; i < numCourses; i++) {
            //从入度为0的结点开始进行深度优先遍历
            if (in.get(i) == null) {
                in.put(i, 0);
                boolean flag = dfs(i, numCourses, new HashSet<Integer>());
                if(flag){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int cur, int numCourses,HashSet<Integer> set) {
        if(!set.add(cur)){
            return false;
        }
        ArrayList<Integer> nextsList = nexts.get(cur);
        if(nextsList==null){
            set.remove(cur);
            return true;
        }
        for(int next : nextsList){
            boolean dfs = dfs(next, numCourses, set);
            if(!dfs){
                return false;
            }
        }
        set.remove(cur);
        return true;
    }

    @Test
    public void test1(){
        //3
        //[[0,1],[0,2],[1,2]]
        int [][]arr = new int[][]{{0,1},{0,2},{1,2}};
        boolean b = canFinish(3, arr);
        System.out.println(b);
    }
}
