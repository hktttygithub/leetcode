package hkttty.niuke;

import hkttty.leetcode.TreeNode;
import org.junit.Test;

import java.util.LinkedList;

public class XulieHua {
    String Serialize(TreeNode root) {
        if(root==null){
            return "#";
        }
        StringBuilder str = new StringBuilder("");
        LinkedList<TreeNode> list = new LinkedList<>();
        list.addLast(root);
        while(!list.isEmpty()){
            root = list.pollFirst();
            if(root==null){
                str.append("#" + ",");
                continue;
            }else{
                str.append(root.val + ",");
                list.addLast(root.left);
                list.addLast(root.right);
            }
        }
        str.deleteCharAt(str.length()-1);
        return new String(str);

    }
    TreeNode Deserialize(String str) {
        if(str==null || str.charAt(0)==('#')){
            return null;
        }
        LinkedList<TreeNode> list = new LinkedList<>();
        String[] split = str.split(",");
        TreeNode root =  new TreeNode(Integer.valueOf(split[0]));
        list.add(root);
        int index = 1;
        while (!list.isEmpty()){
            TreeNode node = list.pollFirst();
            node.left = build(split[index++]);
            if(node.left!=null){
                list.addLast(node.left);
            }
            node.right = build(split[index++]);
            if(node.right!=null){
                list.addLast(node.right);
            }
        }
        return root;
    }

    private TreeNode build(String str){
        if(str.equals("#")){
            return null;
        }else{
            return new TreeNode(Integer.valueOf(str));
        }
    }

    @Test
    public void test1(){
        TreeNode deserialize = Deserialize("8,6,10,5,7,9,11,#,#,#,#,#,#,#,#");
        //TreeNode.deserialize("8,6,10,5,7,9,11");
    }
}
