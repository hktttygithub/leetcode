package hkttty.jian.page1;

import hkttty.leetcode.TreeNode;

import java.util.HashMap;
import java.util.HashSet;

public class No4 {
    //输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
    // 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
    HashMap<Integer,Integer> map = new HashMap<>();
    int index = 0;
    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        if(pre.length==0 || in.length==0 || pre.length!=in.length){
            return null;
        }
        for(int i=0;i<in.length;i++){
            map.put(in[i],i);
        }
        return build(pre,0,pre.length);
    }

    TreeNode build(int []pre,int left,int right){
        if(left<right){
            int val = pre[index++];
            TreeNode node = new TreeNode(val);
            int inIndex = map.get(val);
            node.left = build(pre,left,inIndex);
            node.right = build(pre,inIndex+1,right);
            return node;
        }
        HashSet set = new HashSet();
        HashMap map = new HashMap();
        map.remove("s");
        set.add("");
        return null;
    }
}
