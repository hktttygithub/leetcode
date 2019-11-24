package hkttty.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Node133_dfs {
    private class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
        }

        public Node(int _val, List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        HashMap<Node,Node> map = new HashMap<>();
        dfs(node,map);
        return map.get(node);
    }

    private void dfs(Node node, HashMap<Node, Node> map) {
        if(node==null){
            return;
        }
        if(map.containsKey(node)){
            return;
        }
        Node copy = new Node(node.val,new ArrayList<>());
        map.put(node,copy);
        for(Node next : node.neighbors){
            dfs(next,map);
            Node copyNext = map.get(next);
            copy.neighbors.add(copyNext);
        }
    }
}
