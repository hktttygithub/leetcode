package hkttty.tree;


//找到中序遍历的下一个节点
//每个结点除了左右孩子外，还有一个结点指向了父亲结点
public class FindNextTree {
    public static class Node {
        public int value;
        public Node left;
        public Node right;
        public Node parent;

        public Node(int data) {
            this.value = data;
        }
    }

    //如果当前结点有有子树，找右子树中最左的节点
    //如果没有右子树，往上找
    //如果当前节点是父节点的右孩子，说明在中序遍历的过程中
    //父节点已经遍历过了，所以继续往上找
    //直到当前节点是父节点的左孩子，那么这个父节点就是要找的节点

    public Node find(Node node){
        if(node.right!=null){
            node = node.right;
            while (node.left!=null){
                node = node.left;
            }
            return node;
        }else {
            Node parent  = node.parent;
            while (parent!=null){
                if(parent.left == node){
                    return parent;
                }
                node = parent;
                parent = node.parent;
            }
            return null;
        }
    }

}
