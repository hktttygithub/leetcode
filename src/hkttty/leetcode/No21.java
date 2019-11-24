package hkttty.leetcode;

import org.junit.Test;

public class No21 {
    ListNode head; //头结点，存值

    // Definition for singly-linked list.
    void add(int val){
        ListNode node = new ListNode(val);
        if(this.head==null){
            head = node;
        }else{
            //因为不是双端链表，每次add都要遍历
            ListNode cur = head;
            while(cur.next!=null){
                cur = cur.next;
            }
            cur.next = node;
        }
    }

    public void printAll(){
        while(this.head!=null){
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
    @Test
    public void test1(){
        No21 node1 = new No21();
        No21 node2 = new No21();
        node1.add(1);
        node1.add(2);
        node1.add(4);
        node2.add(1);
        node2.add(3);
        node2.add(4);
        ListNode listNode = mergeTwoLists(node1.head, node2.head);
        System.out.println("\nprint:");
        while(listNode!=null){
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        ListNode node;
        if (l1.val < l2.val) {
            node = new ListNode(l1.val);
            l1 = l1.next;
        } else {
            node = new ListNode(l2.val);
            l2 = l2.next;
        }
        ListNode head = node;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                node.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                node.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            node = node.next;
        }
        while (l1 != null) {
            node.next = new ListNode(l1.val);
            l1 = l1.next;
            node = node.next;
        }
        while (l2 != null) {
            node.next = new ListNode(l2.val);
            l2 = l2.next;
            node = node.next;
        }
        return head;

    }

    public ListNode swapPairs(ListNode head) {
        while(head==null || head.next ==null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        while(head!=null && head.next!=null){
            pre.next = head.next;
            pre = pre.next;
            head.next = pre.next;
            head = head.next;
        }
        return dummy.next;
    }

}
