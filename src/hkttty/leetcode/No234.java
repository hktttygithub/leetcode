package hkttty.leetcode;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Stack;

public class No234 {
    //主要思想是进栈，然后出栈进行比较
    // need n extra space
    public boolean isPalindrome(ListNode head) {
        if(head==null){
            return true;
        }
        ListNode cur = head;
        ArrayDeque<ListNode> deque = new ArrayDeque<>();
        while (cur!=null){
            deque.push(cur);
            cur = cur.next;
        }
        int count = 1;
        int length = deque.size()/2;
        while(count<=length){
            if(!(deque.pop().val == head.val)){
                return false;
            }
            head = head.next;
            count++;
        }
        return true;
    }

    // need n/2 extra space
    // 快指针与慢指针，目的是把慢指针定位到 （如果n是偶数，定位到n/2+1。如果n是奇数，定位到n/2+2）
    public static boolean isPalindrome2(ListNode head) {
        if(head==null || head.next==null)
            return true;
        ListNode fast = head;
        ListNode slow = head.next;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ArrayDeque<ListNode> deque = new ArrayDeque<>();
        while(slow!=null){
            deque.push(slow);
            slow = slow.next;
        }
        while (!deque.isEmpty()){
            if(deque.pop().val != head.val){
                return false;
            }
            head = head.next;
        }
        return true;
    }

    @Test
    public void test1(){
        ListNode listNOde = new ListNode(0);
        ListNode head = listNOde.newList(new int[]{1, 1, 2, 1});
        boolean palindrome = isPalindrome(head);
        System.out.println(palindrome);
    }
}
