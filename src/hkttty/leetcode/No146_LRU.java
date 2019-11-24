package hkttty.leetcode;

import java.util.HashMap;

public class No146_LRU {
    int capacity;
    int size = 0;
    Node tail = null;
    Node head = null;
    HashMap<Integer, Node> map = new HashMap<>();

    class Node {
        Node next;
        Node pre;
        int value;
        int key;

        Node(int key,int value) {
            this.key = key;
            this.value = value;
        }
    }

    public No146_LRU(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node cur = map.get(key);
        if (cur == tail) {

        } else if (cur == head) {
            cur.next.pre = null;
            head = cur.next;
            tail.next = cur;
            cur.pre = tail;
            cur.next = null;
            tail = cur;
        } else {
            cur.pre.next = cur.next;
            tail.next = cur;
            cur.next = null;
            cur.pre = tail;
            tail = cur;
        }
        return map.get(key).value;
    }

    public void put(int key, int value) {
        Node newNode = new Node(key,value);
        if(get(key)==-1){ //原队列里不存在
            map.put(key, newNode);
            if (head == null) {
                head = newNode;
                tail = newNode;
            }else{
                newNode.pre = tail;
                tail.next = newNode;
                tail = newNode;
            }
            size++;
        }else {
            //原队列里存在，只需要调整位置，重新设置value即可
            tail.value = value;
        }
        if (size > capacity) {
            remove();
        }
    }
    private void remove() {
        map.remove(head.key);
        if (head == tail) {
            size--;
            head = null;
            tail = null;
            return;
        } else {
            head.next.pre = null;
            head = head.next;
            size--;
        }
    }

}