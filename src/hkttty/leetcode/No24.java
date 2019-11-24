package hkttty.leetcode;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayDeque;

public class No24 {
    @Test
    public void test1(){
        int [] a = {1,2,3,4};
        int [] b = {2,4,3};
        ListNode node = new ListNode(-1);
        ListNode head1 = node.newList(a);
        ListNode head2 = node.newList(b);
//        while (head!=null){
//            System.out.print(head.val + " ");
//            head = head.next;
//        }
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<Integer>();
        Integer pop = arrayDeque.pop();
        arrayDeque.isEmpty();
        ListNode listNode = swapPairs(head1);
        System.out.println(listNode);
    }

    public ListNode swapPairs(ListNode head) {
        while(head==null || head.next ==null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode help;
        while(head!=null && head.next!=null){
            /*pre.next = head.next;
            pre = pre.next;
            help = head;
            head.next = pre.next;
            head = head.next;
            pre.next =help;*/
            pre.next = head.next;
            help = head.next.next;
            pre.next.next = head;
            pre = head;
            head.next = help;
            head = help;
        }
        return dummy.next;
    }
}
