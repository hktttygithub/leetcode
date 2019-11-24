package hkttty.zuo.class_05;

import java.util.HashMap;
import java.util.List;

public class Code_04_UnionFind {
    //时间复杂度
    //？

	public  class Node {
		// whatever you like
	}

	public static class UnionFindSet {
	    //代表父类结点
		public HashMap<Node, Node> fatherMap;

		//只有当这个结点是当前集合的代表结点时才有效，代表集合的节点数
		public HashMap<Node, Integer> sizeMap;

		public UnionFindSet() {
			fatherMap = new HashMap<Node, Node>();
			sizeMap = new HashMap<Node, Integer>();
		}

		//初始化时应该获取所有节点
		public void makeSets(List<Node> nodes) {
			fatherMap.clear();
			sizeMap.clear();
			for (Node node : nodes) {
				fatherMap.put(node, node);
				sizeMap.put(node, 1);
			}
		}

		//牛逼，找头结点的这个过程，
        // 会将沿途所有结点的父节点都设置为这个集合的head（代表）结点
        //最后将头结点返回
		public Node findHead(Node node) {
			Node father = fatherMap.get(node);
			if (father != node) {
				father = findHead(father);
			}
			fatherMap.put(node, father);
			return father;
		}
		
		public boolean isSameSet(Node a, Node b) {
			return findHead(a) == findHead(b);
		}

		public void union(Node a, Node b) {
			if (a == null || b == null) {
				return;
			}
			Node aHead = findHead(a);
			Node bHead = findHead(b);
			if (aHead != bHead) {
				int aSetSize= sizeMap.get(aHead);
				int bSetSize = sizeMap.get(bHead);
				//根据节点数
                //将结点数少的集合，挂在多的下面
				if (aSetSize <= bSetSize) {
					fatherMap.put(aHead, bHead);
					sizeMap.put(bHead, aSetSize + bSetSize);
				} else {
					fatherMap.put(bHead, aHead);
					sizeMap.put(aHead, aSetSize + bSetSize);
				}
			}
		}

	}

	public static void main(String[] args) {

	}

}
