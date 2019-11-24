package hkttty.leetcode;

import org.junit.Test;

public class No206 {
    private ListNode revHead = null;

    @Test
    public void test1(){
        ListNode listNode = ListNode.newList(new int[]{1, 2, 3, 4, 5});
        reverseList(listNode);
    }

    //递归版
    public ListNode reverseList(ListNode head) {
        if(head==null)
            return null;
        ListNode dummy = null;
        rev(dummy,head);
        return revHead;
    }

    void rev(ListNode pre,ListNode head){
        if(head.next==null) {
            revHead = head;
            head.next = pre;
            return;
        }
        rev(head,head.next);
        head.next = pre;
    }
}
