package hkttty.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class No148 {
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ArrayList<ListNode> list = new ArrayList<>();
        while(head!=null){
            list.add(head);
            head = head.next;
        }
        Collections.sort(list, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        ListNode pre = list.get(0);
        ListNode cur = null;
        for(int i =1 ; i<list.size();i++){
            cur = list.get(i);
            pre.next = cur;
            pre = cur;
        }
        list.get(list.size() - 1).next = null;

        return list.get(0);
    }

    public static void main(String[] args) {
        ListNode listNode = ListNode.newList(new int[]{4, 2, 1, 3});
        ListNode listNode1 = new No148().sortList(listNode);
        ListNode.printAll(listNode1);
    }
}
