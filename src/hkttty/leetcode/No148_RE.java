package hkttty.leetcode;

import org.junit.Test;

public class No148_RE {
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        return sort1(head);
    }

    private ListNode sort1(ListNode head) {
        if(head.next==null){
            return head;
        }
        ListNode n1 = head;
        ListNode n2 = head;
        ListNode pre = null;
        while (n2!=null && n2.next!=null){
            pre = n1;
            n1 = n1.next;
            n2 = n2.next.next;
        }
        pre.next = null;
        ListNode left = sort1(head);
        ListNode right = sort1(n1);
        return merge(left,right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        while (left !=null && right!=null){
            if(left.val<right.val){
                pre.next = left;
                left = left.next;
            }else {
                pre.next = right;
                right = right.next;
            }
            pre = pre.next;
        }
        while (left!=null){
            pre.next = left;
            left = left.next;
        }
        while (right!=null){
            pre.next = right;
            pre = pre.next;
            right = right.next;
        }
        return dummy.next;
    }

    @Test
    public void test1(){
        int []arr= new int[]{1,2,3,4};
        ListNode listNode = sortList(ListNode.newList(arr));
        ListNode.printAll(listNode);
    }
}
