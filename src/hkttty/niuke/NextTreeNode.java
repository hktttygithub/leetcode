package hkttty.niuke;

public class NextTreeNode {

public class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null; // parent

    TreeLinkNode(int val) {
        this.val = val;
    }
}

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }
        TreeLinkNode help;
        if (pNode.left != null) {
            help = pNode.left;
            while (help.left != null) {
                help = help.left;
            }
            return help;
        } else if (pNode.right != null) {
            help = pNode.right;
            while (help.left != null) {
                help = help.left;
            }
            return help;
        } else if (pNode.next == null) {
            return null;
        } else {
            help = pNode.next;
            while (pNode != help.left){
                pNode = help;
                help = help.next;
            }
            return help;
        }
    }

}
