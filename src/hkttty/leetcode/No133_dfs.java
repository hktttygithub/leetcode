package hkttty.leetcode;

import org.junit.Test;

import java.util.*;

public class No133_dfs {

    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
        }

        public Node(int _val, List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    class Solution {
        public Node cloneGraph(Node node) {
            if(node==null){
                return null;
            }
            return dfs(node,new HashMap<>());
        }

        Node dfs(Node node,HashMap<Node,Node> map){
            if(map.containsKey(node)){
                return map.get(node);
            }
            Node copy  =  new Node(node.val,new ArrayList<>());
            map.put(node,copy);
            for(Node next : node.neighbors){
                Node nextCopy = dfs(next, map);
                copy.neighbors.add(nextCopy);
            }
            return copy;
        }

    }

    @Test
    public void test1(){
        Solution solution = new Solution();
        Node node1 = new Node(1, new ArrayList<>());
        Node node2 = new Node(2,new ArrayList<>());
        Node node3 = new Node(3,new ArrayList<>());
        node1.neighbors.add(node2);
        node1.neighbors.add(node3);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node1);
        solution.cloneGraph(node1);
    }
}
