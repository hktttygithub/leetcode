package hkttty.leetcode;

import java.util.*;

public class No133 {
    //给定无向连通图中一个节点的引用，返回该图的深拷贝（克隆）。
    // 图中的每个节点都包含它的值 val（Int） 和其邻居的列表（list[Node]）。

    // Definition for a Node.
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

    class Solution {
        public Node cloneGraph(Node node) {
            if (node == null) {
                return null;
            }
            Node head = new Node(node.val, new ArrayList<>());
            Node copy = head;

            LinkedList<Node> queue = new LinkedList<>();
            HashMap<Node, Node> map = new HashMap<>();
            queue.add(node);
            map.put(node, copy);
            while (!queue.isEmpty()) {
                node = queue.pollLast();
                Node copyNode = map.get(node);
                for (Node next : node.neighbors) {
                    if (!map.containsKey(next)) {
                        map.put(next,new Node(next.val,new ArrayList<>()));
                        queue.add(next);
                    }
                    copyNode.neighbors.add(map.get(next));
                }
            }
            return head;
        }



    }

    //{"$id":"1","neighbors":[{"$id":"2","neighbors":[{"$ref":"1"}],"val":2},
    // {"$id":"3","neighbors":[{"$ref":"1"},{"$id":"4","neighbors":
    // [{"$ref":"3"}],"val":3}],"val":4}],"val":1}

    //{"$id":"1","neighbors":[{"$id":"2","neighbors":[{"$ref":"1"},
    // {"$id":"3","neighbors":[{"$ref":"2"},{"$id":"4","neighbors":
    // [{"$ref":"3"},{"$ref":"1"}],"val":4}],"val":3}],"val":2},{"$ref":"4"}],"val":1}
}
