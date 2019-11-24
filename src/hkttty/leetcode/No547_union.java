package hkttty.leetcode;

import java.util.HashSet;

public class No547_union {
    int []father;

    public int findCircleNum(int[][] m) {
        if(m.length<=0 || m[0].length<=0){
            return 0;
        }
        father = new int[m.length];
        for(int i=0;i<father.length;i++){
            father[i] = i;//一开始自己是自己的父亲结点
        }
        for(int i=0;i<m.length;i++){
            for(int j=0;j<m.length;j++){
                if(i!=j && m[i][j]==1){
                    union(i,j);
                }
            }
        }
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<m.length;i++){
            set.add(findHead(i));
        }
        return set.size();
    }

    int findHead(int node){
        int head = father[node];
        if(head!=node){
            head = findHead(head);
        }
        father[node] = head;
        return head;
    }

    private void union(int node1, int node2) {
        int head1 = findHead(node1);
        int head2 = findHead(node2);
        if(head1==head2)
            return;
        //将head2挂在head1下面
        father[head2] = head1;
    }
}
