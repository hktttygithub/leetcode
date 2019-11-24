package hkttty.jian.page1;

import hkttty.leetcode.ListNode;

import java.util.ArrayList;

public class No3 {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> res = new ArrayList<>();
        travel(listNode,res);
        return res;
    }

    private void travel(ListNode node, ArrayList<Integer> res) {
        if(node==null){
            return;
        }
        travel(node.next,res);
        res.add(node.val);
    }

    ListNode reverseListNode(ListNode cur,ListNode pre){
        if(cur==null){
            return pre;
        }
        ListNode head = reverseListNode(cur.next,cur);
        cur.next = pre;
        return head;
    }
}
