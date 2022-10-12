package Leetcode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/
 */

public class L1038_M_BinarySearchTreetoGreaterSumTree {

    static class TreeNode {
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
//        TreeNode test = new TreeNode(4,
//                new TreeNode(2, new TreeNode(1), new TreeNode(3)),
//                new TreeNode(7));

//        TreeNode test = new TreeNode(4,
//                null,
//                new TreeNode(7,
//                        new TreeNode(6, new TreeNode(5), null),
//                        new TreeNode(8, null, new TreeNode(9))));

        TreeNode test = new TreeNode(4,
                new TreeNode(1, new TreeNode(0), new TreeNode(2, null, new TreeNode(3))),
                new TreeNode(6, new TreeNode(5), new TreeNode(7, null, new TreeNode(8))));

        test = bstToGst(test);
        System.out.println(test);
    }

    public static TreeNode finalNode;
    public static int value;

    public static TreeNode bstToGst(TreeNode root) {
        finalNode = root;
        value = 0;
        if (root == null) {
            return null;
        }
        /**
         * iterativeMethod
         * */
        iterativeMethod(root);
        /**
         * recursiveMethod
         * */
//        recursiveMethod(root);
        return finalNode;
    }

    private static void recursiveMethod(TreeNode root) {
        if (root == null) {
            return;
        }
        recursiveMethod(root.right);
        root.val += value;
        value = root.val;
        recursiveMethod(root.left);
    }

    private static void iterativeMethod(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode currentNode = stack.pop();
            if (currentNode != null) {
                if (currentNode.left != null) {
                    stack.add(currentNode.left);
                }
                stack.add(currentNode);
                stack.add(null);
                if (currentNode.right != null) {
                    stack.add(currentNode.right);
                }
            } else {
                TreeNode temp = stack.pop();
                temp.val += value;
                value = temp.val;
            }
        }
    }
}
