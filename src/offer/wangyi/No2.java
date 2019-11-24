package offer.wangyi;

import hkttty.leetcode.ListNode;

import java.util.HashMap;

public class No2 {
    HashMap<Integer,Integer> map = new HashMap<>();
    //去除链表中重复元素，最多出现两次
    public void removeDuplicates(ListNode head) {
        if(head==null || head.next==null){
            return;
        }
        ListNode cur = head.next;
        ListNode pre = head;
        map.put(pre.val,1);
        while (cur!=null){
            if(!map.containsKey(cur.val)){
                map.put(cur.val,1);

                pre = cur;
                cur = cur.next;
            }else{
                Integer count = map.get(cur.val);
                if(count<2){
                    map.put(cur.val,count+1);

                    pre = cur;
                    cur = cur.next;
                }else{
                    //delete
                    cur = cur.next;
                    pre.next = cur;
                }
            }
        }
//        ListNode.printAll(head);
    }

    public static void main(String[] args) {
        //10
        //1 2 2 2 3 3 4 5 5 5
        ListNode listNode = ListNode.newList(new int[]{2,2,2});
        new No2().removeDuplicates(listNode);


    }
}
