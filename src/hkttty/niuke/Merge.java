package hkttty.niuke;

import hkttty.leetcode.ListNode;
import org.junit.Test;

//合并两个排序的链表
public class Merge {
    @Test
    public void test1(){
        ListNode listNode = ListNode.newList(new int[]{1, 3, 5});
        ListNode merge = Merge(listNode, null);
        ListNode.printAll(merge);
    }

    public ListNode Merge(ListNode list1, ListNode list2) {
        if(list1==null && list2==null){
            return null;
        }
        ListNode dummy = new ListNode(-1);
        ListNode help = dummy;
        while(list1!=null && list2!=null){
            int val1 = list1.val;
            int val2 = list2.val;
            if(val1<val2){
                list1 = list1.next;
                help.next = new ListNode(val1);
            }else{
                list2 = list2.next;
                help.next = new ListNode(val2);
            }
            help = help.next;
        }
        while(list1!=null){
            help.next = new ListNode(list1.val);
            list1 = list1.next;
            help = help.next;
        }
        while(list2!=null){
            help.next = new ListNode(list2.val);
            list2 = list2.next;
            help = help.next;
        }
        return dummy.next;
    }
}
