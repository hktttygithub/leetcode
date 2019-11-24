package hkttty.linkedlist;

import java.util.Arrays;

public class LinkedListDemo {
    //头结点是存值的
    private Node head;
    private int size;

    public class Node {
        int value; //数据域
        Node next; //指针域

        public Node(int value) {
            this.value = value;
        }
    }

    //新增
    public void add(int value) {
        Node node = new Node(value);
        if(head==null){
            head = node;
        }else{
            while (head.next!=null){
                head = head.next;
            }
            head.next = node;
        }
    }

    //遍历
    public void printAll(Node node) {
        while (node!=null){
            System.out.println(node.value);
        }
    }

    public static void main(String[] args) {

    }

    private static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
