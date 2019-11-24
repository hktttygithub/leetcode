package hkttty.zuo.class_06;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Code_01_BFS {

	public static void bfs(Node node) {
		if (node == null) {
			return;
		}
		Queue<Node> queue = new LinkedList<>();
		HashSet<Node> map = new HashSet<>();
		queue.add(node);
		map.add(node);
		while (!queue.isEmpty()) {
			Node cur = queue.poll();
			System.out.println(cur.value);
			for (Node next : cur.nexts) {
				if (!map.contains(next)) {
					map.add(next);
					queue.add(next);
				}
			}
		}
	}

	static void bfs_(Node node,HashSet<Node> set){
	    if(node==null){
	        return;
        }
        if(!set.add(node)){
            return;
        }
        System.out.println(node.value);
        for(Node next : node.nexts){
            bfs_(next,set);
        }
    }

}
