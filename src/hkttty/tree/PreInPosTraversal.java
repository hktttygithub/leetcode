package hkttty.tree;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Stack;

//先序、中序、后序遍历树
//递归、非递归
//层序、递归、非递归
public class PreInPosTraversal {
    public class Node {
        int value;
        public Node left;
        public Node right;

        Node(int value) {
            this.value = value;
        }
    }

    //先序 递归
    void preOrderTraversal(Node node) {
        if (node == null)
            return;
        System.out.print(node.value + " ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    //中序 递归
    void inOrderTraversal(Node node) {
        if (node == null)
            return;
        inOrderTraversal(node.left);
        System.out.print(node.value + " ");
        inOrderTraversal(node.right);
    }

    //后序 递归
    void posOrderTraversal(Node node) {
        if (node == null)
            return;
        posOrderTraversal(node.left);
        posOrderTraversal(node.right);
        System.out.print(node.value + " ");
    }

    //层序 非递归
    void traversal(Node node) {
        if (node == null) {
            return;
        }
        ArrayDeque<Node> deque = new ArrayDeque<>();
        deque.offer(node);
//        LinkedList list =null;
//         list.offer("dd");
//        deque.addLast();
        while (!deque.isEmpty()) {
            Node n = deque.poll();
            System.out.print(n.value + " ");
            if (n.left != null)
                deque.offer(n.left);
            if (n.right != null)
                deque.offer(n.right);
        }
    }

    //先序 非递归
    void preOrderTraversal2(Node node) {
        if (node == null) {
            return;
        }
        ArrayDeque<Node> deque = new ArrayDeque<>();
        deque.offer(node);
        while (!deque.isEmpty()) {
            Node pop = deque.pop();
            System.out.print(pop.value + " ");
            if (pop.right != null) {
                deque.push(pop.right);
            }
            if (pop.left != null) {
                deque.push(pop.left);
            }
        }
    }

    //中序 非递归
    /*
     * 先把所有的左孩子入栈，然后弹出最后一个左孩子，打印值
     * 再检查（最后一个左孩子）是否有右孩子，如果有，入栈，继续检查该右孩子是否有左孩子，循环
     *
     * */
    void inOrderTraversal2(Node node) {
        if(node==null)
            return;
        ArrayDeque<Node> deque = new ArrayDeque<>();
        while (node!=null || !deque.isEmpty()){
            if(node!=null){
                deque.push(node);
                node = node.left;
            }else {
                node = deque.pop();
                System.out.print(node.value + " ");
                node = node.right;
            }
        }
    }

    //后序 非递归
    void postTravel(Node node){
        if(node==null)
            return;
        ArrayDeque<Node> deque1 = new ArrayDeque<>();
        ArrayDeque<Node> deque2 = new ArrayDeque<>();
        deque1.push(node);
        while (!deque1.isEmpty()){
            node = deque1.pop();
            deque2.push(node);
            if(node.left!=null)
                deque1.push(node.left);
            if(node.right!=null)
                deque1.push(node.right);
        }
        while(!deque2.isEmpty()){
            System.out.print(deque2.pop().value + " ");
        }
    }

    public static void posOrderUnRecur1(Node head) {
        System.out.print("pos-order: ");
        if (head != null) {
            Stack<Node> s1 = new Stack<Node>();
            Stack<Node> s2 = new Stack<Node>();
            s1.push(head);
            while (!s1.isEmpty()) {
                head = s1.pop();
                s2.push(head);
                if (head.left != null) {
                    s1.push(head.left);
                }
                if (head.right != null) {
                    s1.push(head.right);
                }
            }
            while (!s2.isEmpty()) {
                System.out.print(s2.pop().value + " ");
            }
        }
        System.out.println();
    }

    @Test
    public void test1() {
        Node head = new Node(5);
        head.left = new Node(3);
        head.right = new Node(8);
        head.left.left = new Node(2);
        head.left.right = new Node(4);
        head.left.left.left = new Node(1);
        head.right.left = new Node(7);
        head.right.left.left = new Node(6);
        head.right.right = new Node(10);
        head.right.right.left = new Node(9);
        head.right.right.right = new Node(11);
//        preOrderTraversal(head);
//        System.out.println();
//        preOrderTraversal2(head);
//        inOrderTraversal2(head);
        postTravel(head);
        posOrderUnRecur1(head);
    }


}
