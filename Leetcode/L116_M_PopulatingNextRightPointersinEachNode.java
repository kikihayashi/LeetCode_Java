package Leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class L116_M_PopulatingNextRightPointersinEachNode {

    /**
     * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
     */

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public static void main(String[] args) {
        List<Node> list = new LinkedList<>();

        list.add(new Node(2));
        list.add(new Node(3));
        list.add(new Node(4));
        list.add(new Node(5));

        Node test = new Node(1,
                new Node(2, new Node(4), new Node(5), null),
                new Node(3), null);

        System.out.println(connect(test));
    }

    //本題是給完全二元樹，此解法可以處理一般二元樹
    public static Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node prevRoot = null;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node currentRoot = queue.poll();
                if (currentRoot.left != null) {
                    queue.offer(currentRoot.left);
                }
                if (currentRoot.right != null) {
                    queue.offer(currentRoot.right);
                }
                if (prevRoot != null) {
                    prevRoot.next = currentRoot;
                }
                prevRoot = currentRoot;
            }
        }
        return root;
    }

}
