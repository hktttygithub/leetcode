package hkttty.leetcode;


import java.util.LinkedList;

//二叉树的序列化
public class No297 {
    /*
    * 你可以将以下二叉树：

    1
   / \
  2   3
     / \
    4   5

序列化为 "[1,2,3,null,null,4,5]"

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    * */


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        LinkedList<TreeNode> list = new LinkedList<>();
        list.addLast(root);
        StringBuffer str = new StringBuffer("");
        while (list.size() > 0) {
            root = list.pollFirst();
            if (root == null) {
                str.append("#" + ",");
                continue;
            }
            str.append(root.val + ",");
            list.addLast(root.left);
            list.addLast(root.right);
        }
        str.deleteCharAt(str.length() - 1);
        return new String(str);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data==null || data.length()<=0 || data.equals("#")){
            return null;
        }
        //下一层的节点数一定是这一层的两倍
        String[] split = data.split(",");
        TreeNode head = new TreeNode(Integer.valueOf(split[0]));
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(head);
        int index = 1;
        while (!queue.isEmpty()){
            TreeNode node = queue.pollFirst();
            node.left = build(split[index++]);
            node.right = build(split[index++]);
            if(node.left!=null){
                queue.addLast(node.left);
            }
            if(node.right!=null){
                queue.addLast(node.right);
            }
        }
        return head;
    }

    TreeNode build(String val){
        if(val.equals("#")){
            return null;
        }
        return new TreeNode(Integer.valueOf(val));
    }
}
