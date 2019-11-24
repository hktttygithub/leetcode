package hkttty.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class No297_preorder {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null){
            return "#";
        }
        StringBuilder str = new StringBuilder("");
        StringBuilder builder = preOrder(root, str);
        builder.deleteCharAt(builder.length()-1);
        return new String(builder);
    }

    StringBuilder preOrder(TreeNode node,StringBuilder str){
        if(node==null){
            str.append("#,");
            return null;
        }
        int val = node.val;
        str.append(val + ",");
        preOrder(node.left,str);
        preOrder(node.right,str);
        return str;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data==null || data.length()<=0 || data.equals("#")){
            return null;
        }
        String[] split = data.split(",");
        LinkedList<String> list = new LinkedList<>();
        for (String s : split){
            list.addLast(s);
        }
        return preDeserialize(list);
    }

    private TreeNode preDeserialize(LinkedList<String> list) {
        String val = list.pollFirst();
        if(val==null || val.equals("#")){
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(val));
        node.left = preDeserialize(list);
        node.right = preDeserialize(list);
        return node;
    }

    public static void main(String[] args) {
        TreeNode head = new No297().deserialize("1,2,3,#,#,4,5,#,#,#,#");
        No297_preorder test = new No297_preorder();
        String serialize = test.serialize(head);
        System.out.println(serialize);
        TreeNode deserialize = test.deserialize(serialize);
        TreeNode.printAll(deserialize);
    }
}
