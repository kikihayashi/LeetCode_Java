package Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class L589_E_NaryTreePreorderTraversal {

    /**
     * 中 -> 左 -> 右
     * https://leetcode.com/problems/n-ary-tree-preorder-traversal/
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

        System.out.println(preorder(test));
    }

    /**
     * 遞迴、跌代統一寫法-----------------------------------------------------------------
     */

    public static List<Integer> list;

    public static List<Integer> preorder(Node root) {
        list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        /**
         *  iterativeMethod
         */
        iterativeM(root);

        /**
         *  recursiveMethod
         */
//        recursiveM(root);
        return list;

    }

    //遞迴統一寫法
    private static void recursiveM(Node root) {
        list.add(root.val);
        if (root == null) {
            return;
        }
        if (root.children != null) {
            for (int i = 0; i < root.children.size(); i++) {
                recursiveM(root.children.get(i));
            }
        }
    }

    //跌代統一寫法
    private static void iterativeM(Node root) {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node currentNode = stack.pop();
            list.add(currentNode.val);
            if (currentNode.children != null) {
                for (int i = currentNode.children.size() - 1; i >= 0; i--) {
                    Node node = currentNode.children.get(i);
                    stack.push(node);
                }
            }

        }
    }


    //跌代統一寫法
    private static void iterativeTemplate(Node root) {
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node currentNode = stack.pop();
            if (currentNode != null) {
                if (currentNode.children != null) {
                    for (int i = currentNode.children.size() - 1; i >= 0; i--) {
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


    /**
     * 遞迴、跌代統一寫法-----------------------------------------------------------------
     */
}
