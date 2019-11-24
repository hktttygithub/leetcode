package hkttty.niuke;

import org.junit.Test;

public class Quan {
    class Node{
        int val;
        Node next;
        Node(int val){
            this.val = val;
        }
    }

    public int LastRemaining_Solution(int n, int m) {
        if(n<=0){
            return -1;
        }
        Node node = new Node(0);
        Node head = node;
        for(int i=1;i<n;i++){
            Node newNode = new Node(i);
            node.next = newNode;
            node = newNode;
        }
        node.next = head;
        while(head.next!=head){
            for(int i=0;i<m-1;i++){
                node = head;
                head = head.next;
            }
            node.next = head.next;
            head = node.next;
        }
        return head.val;
    }

    @Test
    public void test1(){
        int i = LastRemaining_Solution(5, 3);
        System.out.println(i);
    }
}
