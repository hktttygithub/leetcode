package hkttty.niuke;

import hkttty.leetcode.ListNode;

//题目描述
//输入一个链表，输出该链表中倒数第k个结点。
public class KNode {
    public ListNode FindKthToTail(ListNode head, int k) {
        if(head==null){
            return null;
        }
        ListNode node = head;
        int count = 0;
        while(node!=null){
            node = node.next;
            count++;
        }
        if(k>count){
            return null;
        }
        node = head;
        int flag = count-k;
        while(flag>0){
            node = node.next;
            flag--;
        }
        return node;
    }

    public static void main(String[] args) {
        ListNode listNode = ListNode.newList(new int[]{1, 2, 3, 4, 5});
        KNode t = new KNode();
        t.FindKthToTail(listNode,1);
    }
}
