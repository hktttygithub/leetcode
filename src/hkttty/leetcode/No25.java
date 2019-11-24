package hkttty.leetcode;

import org.junit.Test;

public class No25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null || head.next==null || k==1){
            return head;
        }
        ListNode node = head;
        int length = 0;
        while(node!=null){
            length++;
            node = node.next;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        ListNode ne = cur.next;
        int count = 0;
        while (count + k <=length){
            count += k;
            pre = res(pre,cur,ne,k);
            cur = pre.next;
            if(cur==null){
                break;
            }
            ne = cur.next;
        }

        return dummy.next;
    }

    ListNode res(ListNode pre,ListNode cur,ListNode ne,int k){
        ListNode head = cur;
        while (k>1){
            ListNode temp = ne.next;
            ne.next = cur;
            cur = ne;
            ne = temp;
            k--;
        }
        head.next = ne;
        pre.next =cur;
        return head;
    }

    @Test
    public void test1(){
        int []arr = new int[]{1,2};
        ListNode head = ListNode.newList(arr);
        ListNode listNode1 = reverseKGroup(head, 2);
        ListNode.printAll(listNode1);

    }
}
