package hkttty.leetcode;

import org.junit.Test;

public class No92 {

    private ListNode newHead = null;
    int count = 0;

    @Test
    public void test1(){
        ListNode listNode = ListNode.newList(new int[]{3,5});
        ListNode listNode1 = reverseBetween(listNode, 1,2);
//        System.out.println(listNode1);
        ListNode.printAll(listNode1);
    }


    ListNode left = null;
    boolean flag = false;

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head==null || head.next==null || m-n==0){
            return head;
        }
        ListNode cur =head;
        for(int i=1;i<m;i++){
            cur = cur.next;
        }
        left = cur;
        reverse(cur,n-m+1);

        return head;
    }

    void reverse(ListNode node,int count){
        if(count==0){
            return;
        }
        reverse(node.next,count-1);
        if(left==node || flag || node.next==left){
            flag = true;
            return;
        }
        int temp = left.val;
        left.val = node.val;
        node.val = temp;
        left = left.next;
    }
}
