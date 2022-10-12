package Leetcode;

import java.util.*;

public class L590_E_NaryTreePostorderTraversal {

    /**
     * 左 -> 右 -> 中
     * https://leetcode.com/problems/n-ary-tree-postorder-traversal/
     */

    public static class Node {
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

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
//        TreeNode test = new TreeNode(3, new TreeNode(1, null, new TreeNode(2)), null);
//        TreeNode test = new TreeNode(4, new TreeNode(1, new TreeNode(2, new TreeNode(3),null), null), null);
//        TreeNode test = new TreeNode(1, null, new TreeNode(2,null, new TreeNode(3, null, new TreeNode(4))));
//        TreeNode test = new TreeNode(3, new TreeNode(2, null, new TreeNode(4, new TreeNode(1), null)), null);
//        TreeNode test = new TreeNode(1, new TreeNode(2, new TreeNode(4), null),
//                new TreeNode(3, new TreeNode(5), new TreeNode(6)));
//        TreeNode test = new TreeNode(1,
//                new TreeNode(2, null, new TreeNode(4, new TreeNode(7), new TreeNode(8, new TreeNode(11), null))),
//                new TreeNode(3,
//                        new TreeNode(5, new TreeNode(9), null),
//                        new TreeNode(6, new TreeNode(10), null)));

        List<Node> list = new LinkedList<>();

        list.add(new Node(2));
        list.add(new Node(3));
        list.add(new Node(4));
        list.add(new Node(5));

        Node test = new Node(1, list);

        System.out.println(postorder(test));
    }

    /**
     * 遞迴、跌代統一寫法-----------------------------------------------------------------
     */

    public static List<Integer> list;

    public static List<Integer> postorder(Node root) {
        list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        /**
         *  iterativeMethod
         */
//        iterativeTemplate(root);

        /**
         *  recursiveMethod
         */
        recursiveTemplate(root);
        Collections.reverse(list);
        return list;

    }

    //跌代統一寫法
    private static void iterativeTemplate(Node root) {
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node currentNode = stack.pop();
            if (currentNode != null) {
                if (currentNode.children != null) {
                    for (int i = 0; i < currentNode.children.size(); i++) {
                        stack.push(currentNode.children.get(i));
                    }
                }
                stack.push(currentNode);
                stack.push(null);//標記(固定放在中間節點後面)
            } else {
                list.add(stack.pop().val);
            }
        }
        return;
    }

    //遞迴統一寫法
    private static void recursiveTemplate(Node root) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        if (root.children != null) {
            for (int i = root.children.size() - 1; i >= 0; i--) {
                recursiveTemplate(root.children.get(i));
            }
        }
    }

    /**
     * 遞迴、跌代統一寫法-----------------------------------------------------------------
     */
}
