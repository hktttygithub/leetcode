package hkttty.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class No997 {
    public int findJudge(int N, int[][] trust) {
        int[][] people = new int[N][2];
        for(int[] person : trust){
            int out = person[0];
            int in = person[1];
            people[out - 1][0] ++;
            people[in - 1][1] ++;
        }
        for(int i = 0; i < N; i ++){
            if(people[i][0] == 0 && people[i][1] == N - 1)
                return i + 1;
        }
        return -1;
    }

    @Test
    public void test1() {
//        11
//[[1,8],[1,3],[2,8],[2,3],[4,8],[4,3],[5,8],[5,3],[6,8],[6,3],[7,8],[7,3],[9,8],[9,3],[11,8],[11,3]]
        int[][] arr = new int[][]{{1,8},{1,3},{2,8},{2,3},{4,8},{4,3},{5,8},{5,3},{6,8},{6,3},{7,8},{7,3},{9,8},{9,3},{11,8},{11,3}};
        int judge = findJudge(2, arr);
        System.out.println(judge);

    }
}
