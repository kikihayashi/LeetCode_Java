package LeetCode;

import java.util.*;

public class L559_E_MaximumDepthofNaryTree {

    /**
     * https://leetcode.com/problems/maximum-depth-of-n-ary-tree/
     */

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public static void main(String[] args) {

        List<Node> list = new LinkedList<>();

        list.add(new Node(2));
        list.add(new Node(3));
        list.add(new Node(4));
        list.add(new Node(5));

        Node test = new Node(1, list);

        System.out.println(maxDepth(test));
    }


    public static int maxDepth(Node root) {
        int depth = 0;
        /**
         * iterativeMethod
         **/
//        return iterativeMethod(root);
        /**
         * recursiveMethod
         **/
        return recursiveMethod(root);
    }

    private static int recursiveMethod(Node root) {
        if (root == null) {
            return 0;
        }
        int depth = 0;
        if (root.children != null) {
            for (int i = 0; i < root.children.size(); i++) {
                depth = Math.max(depth, recursiveMethod(root.children.get(i)));
            }
        }
        return 1 + depth;
    }

    private static int iterativeMethod(Node root) {
        if (root == null) {
            return 0;
        }
        int depth = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node currentRoot = queue.poll();
                if (currentRoot.children != null) {
                    for (int j = 0; j < currentRoot.children.size(); j++) {
                        queue.offer(currentRoot.children.get(j));
                    }
                }
            }
            depth++;
        }
        return depth;
    }

}
