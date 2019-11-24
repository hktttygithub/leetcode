package hkttty.leetcode;


import org.junit.Test;

import java.util.ArrayList;

//合并k个链表
public class No23 {

    public ListNode mergeKLists(ListNode[] lists) {
        ArrayList<ListNode> priorityQueue = new ArrayList<>();
        for (ListNode node : lists) {
            while (node != null) {
                priorityQueue.add(node);
                adjust(priorityQueue);
                node = node.next;
            }
        }
        int size = priorityQueue.size();
        if(size<=0){
            return null;
        }
        if(size==1){
            return priorityQueue.get(0);
        }

        while (size > 0) {
            swap(priorityQueue, 0, --size);
            sort(priorityQueue, size);
        }
        ListNode head = priorityQueue.get(0);
        head.next = priorityQueue.get(1);
        for (int i = 1; i < priorityQueue.size()-1; i++) {
            ListNode listNode = priorityQueue.get(i);
            listNode.next = priorityQueue.get(i+1);
        }
        priorityQueue.get((priorityQueue.size()-1)).next = null;
        return head;
    }

    private void sort(ArrayList<ListNode> priorityQueue, int size) {
        int index = 0;
        while ((index * 2 + 1) < size) {
            int parVal = priorityQueue.get(index).val;

            int sonIndex = (index * 2 + 2 < size && priorityQueue.get(index * 2 + 2).val > priorityQueue.get(index * 2 + 1).val) ?
                    index * 2 + 2 : index * 2 + 1;
            int sonVal = priorityQueue.get(sonIndex).val;
            if (parVal > sonVal) {
                return;
            } else {
                swap(priorityQueue, sonIndex, index);
                index = sonIndex;
            }
        }
    }

    private void adjust(ArrayList<ListNode> priorityQueue) {
        int index = priorityQueue.size() - 1;
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (priorityQueue.get(index).val > priorityQueue.get(parent).val) {
                swap(priorityQueue, index, parent);
                index = parent;
            } else {
                return;
            }
        }
    }

    private void swap(ArrayList<ListNode> priorityQueue, int index, int parent) {
        ListNode temp = priorityQueue.get(index);
        priorityQueue.set(index, priorityQueue.get(parent));
        priorityQueue.set(parent, temp);
    }

    @Test
    public void test1(){
        ListNode list1 = ListNode.newList(new int[]{1, 4, 5});
        ListNode list2 = ListNode.newList(new int[]{1, 3, 4});
        ListNode list3 = ListNode.newList(new int[]{2,6});
        ListNode []lists = new ListNode[]{list1,list2,list3};
        ListNode listNode = mergeKLists(lists);
        ListNode.printAll(listNode);
    }
}
