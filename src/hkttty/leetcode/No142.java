package hkttty.leetcode;

import java.util.HashMap;

public class No142 {

    /**
     * Definition for singly-linked list.
     * class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */
    public class Solution {
        public ListNode detectCycle(ListNode head) {
            if(head==null || head.next==null){
                return null;
            }
            HashMap<ListNode,Integer> map = new HashMap<>();
            ListNode cur = head;
            int count = 0;
            while(cur!=null){
                if(!map.containsKey(cur)){
                    map.put(cur,count++);
                    cur = cur.next;
                }else{
                    return cur;
                }
            }
            return null;
        }
    }
}
