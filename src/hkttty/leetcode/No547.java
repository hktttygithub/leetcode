package hkttty.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;

public class No547 {
    int []faterUnion;
    HashMap<Integer,Integer> map = new HashMap<>();


    public int findCircleNum(int[][] m) {
        if(m==null || m.length<=0){
            return 0;
        }
        faterUnion = new int[m.length];
        for (int i = 0; i < faterUnion.length; i++) {
            faterUnion[i] = i;
            map.put(i,1);
        }
        for(int i=0;i<m.length;i++){
            for (int j=0;j<m[0].length;j++){
                if(i!=j && m[i][j]==1)
                    unionNode(i,j);
            }
        }
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<m.length;i++){
            set.add(findHead(i));
        }
        return set.size();
    }

    private Integer findHead(int son) {
        int head = faterUnion[son];
        if (head!=son){
            head = findHead(head);
        }
        faterUnion[son] = head;
        return head;
    }

    private void unionNode(int node1,int node2) {
        int head1 = findHead(node1);
        int head2 = findHead(node2);
        if(head1==head2){
            return;
        }else{
            int size1 = map.get(head1);
            int size2 = map.get(head2);
            if(size1>=size2){
                faterUnion[head2] = head1;
            }else{
                faterUnion[head1] = head2;
            }
        }
    }

    @Test
    public void test1(){
        //[[1,0,0,1],[0,1,1,0],[0,1,1,1],[1,0,1,1]]
        int [][]arr = new int[][]{{1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}};
        int circleNum = findCircleNum(arr);
        System.out.println(circleNum);
    }

}
