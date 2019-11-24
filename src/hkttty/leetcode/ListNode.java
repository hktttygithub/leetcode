package hkttty.leetcode;

//结点类
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public static ListNode newList(int []a){
        ListNode head = new ListNode(a[0]);
        ListNode cur = head;
        for (int i = 1; i < a.length; i++) {
            cur.next = new ListNode(a[i]);
            cur = cur.next;
        }
        return head;
    }

    public static void printAll(ListNode head){
        while(head!=null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
