package hkttty.niuke;

import hkttty.leetcode.ListNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PrintListFromTailToHead {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        if(listNode==null){
            return list;
        }
        LinkedList<Integer> help = new LinkedList<>();
        while(listNode!=null){
            help.push(listNode.val);
            listNode = listNode.next;
        }
        while(!help.isEmpty()){
            list.add(help.pop());
        }
        return list;
    }

}
