package hkttty.leetcode;

import java.util.ArrayDeque;

public class No445 {
    public static void main(String[] args) {
        ListNode node = new ListNode(0);
        ListNode listNode1 = node.newList(new int[]{5});
        ListNode listNode2 = node.newList(new int[]{5});
        ListNode listNode3 = addTwoNumbers(listNode1, listNode2);
        ListNode.printAll(listNode3);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null){
            return l2;
        }else if(l2==null){
            return l1;
        }
        ArrayDeque<Integer> stack1 = new ArrayDeque<>();
        ArrayDeque<Integer> stack2 = new ArrayDeque<>();
        while(l1!=null){
            stack1.push(l1.val);
            l1 = l1.next;
        } while(l2!=null){
            stack2.push(l2.val);
            l2 = l2.next;
        }
        int flag=0;
        ArrayDeque<Integer> newLinkedList = new ArrayDeque<Integer>();
        while(!stack1.isEmpty() && !stack2.isEmpty()){
            int value = stack1.pop() + stack2.pop() + flag;
            newLinkedList.push(value%10);
            flag = value/10;
        }
        while(flag!=0){
            if(!stack1.isEmpty() || !stack2.isEmpty()){
                int value = (!stack1.isEmpty()? stack1.pop() : stack2.pop()) + flag;
                newLinkedList.push(value%10);
                flag = flag/10;
            }else{
                newLinkedList.push(flag);
                flag = flag/10;
            }
        }

        if(!stack1.isEmpty()){
            while(!stack1.isEmpty()){
                newLinkedList.push(stack1.pop());
            }
        }else if(!stack2.isEmpty()){
            while(!stack2.isEmpty()){
                newLinkedList.push(stack2.pop());
            }
        }
        ListNode sumLinked = new ListNode(newLinkedList.pop());
        ListNode head = sumLinked;
        while(!newLinkedList.isEmpty()){
            sumLinked.next = new ListNode(newLinkedList.pop());
            sumLinked = sumLinked.next;
        }
        return head;
    }
}
