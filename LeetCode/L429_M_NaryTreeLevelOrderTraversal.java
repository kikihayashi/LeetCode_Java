package LeetCode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class L429_M_NaryTreeLevelOrderTraversal {

    /**
     * https://leetcode.com/problems/n-ary-tree-level-order-traversal/
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

        System.out.println(levelOrder(test));
    }

    public static List<List<Integer>> list;

    public static List<List<Integer>> levelOrder(Node root) {
        list = new LinkedList<>();
        iterativeMethod(root);
//        recursiveMethod(root, 0);
        return list;
    }

    private static void iterativeMethod(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> levelList = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node currentNode = queue.poll();
                if (currentNode.children != null) {
                    for (int j = 0; j < currentNode.children.size(); j++) {
                        queue.offer(currentNode.children.get(j));
                    }
                }
                levelList.add(currentNode.val);
            }
            list.add(levelList);
        }
        return;
    }

    private static void recursiveMethod(Node root, int level) {
        if (root == null) {
            return;
        }
        level++;

        if (list.size() < level) {
            List<Integer> levelList = new LinkedList<>();
            list.add(levelList);
        }

        list.get(level - 1).add(root.val);
        if (root.children != null) {
            for (int i = 0; i < root.children.size(); i++) {
                recursiveMethod(root.children.get(i), level);
            }
        }
        return;
    }
}
