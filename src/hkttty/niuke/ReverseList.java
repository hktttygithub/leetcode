package hkttty.niuke;

import hkttty.leetcode.ListNode;
import org.junit.Test;

public class ReverseList {
    @Test
    public void test1(){
        ListNode listNode = ListNode.newList(new int[]{1, 2, 3, 4, 5});
        ListNode listNode1 = ReverseList(listNode);
        ListNode.printAll(listNode1);
    }

    public ListNode ReverseList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = null;
        ListNode help = head.next;
        while(head!=null && help!=null){
            head.next = dummy.next;
            dummy.next = head;
            head = help;
            help = help.next;
        }
        head.next = dummy.next;
        dummy.next = head;
        return dummy.next;

    }
}
