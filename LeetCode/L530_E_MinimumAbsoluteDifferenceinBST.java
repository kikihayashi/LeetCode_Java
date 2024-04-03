package LeetCode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/minimum-absolute-difference-in-bst/
 */

public class L530_E_MinimumAbsoluteDifferenceinBST {

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

//        TreeNode test = new TreeNode(2,
//                new TreeNode(1),
//                new TreeNode(3));//true

//        TreeNode test = new TreeNode(0, new TreeNode(-1), null);//true

        TreeNode test = new TreeNode(3,
                new TreeNode(1, new TreeNode(0), new TreeNode(2)),
                new TreeNode(5, new TreeNode(4), new TreeNode(6)));//true

        System.out.println(getMinimumDifference(test));
    }

    public static int difference, nowValue;

    public static int getMinimumDifference(TreeNode root) {
        difference = Integer.MAX_VALUE;
        nowValue = Integer.MAX_VALUE;
        /**
         * iterativeMethod
         */
//        iterativeMethod(root);

        /**
         * recursiveMethod
         */
        recursiveMethod(root);
        return difference;
    }

    private static void iterativeMethod(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode currentNode = stack.pop();
            if (currentNode != null) {
                if (currentNode.right != null) {
                    stack.add(currentNode.right);
                }
                stack.add(currentNode);
                stack.add(null);
                if (currentNode.left != null) {
                    stack.add(currentNode.left);
                }
            } else {
                TreeNode temp = stack.pop();
                if (nowValue == Integer.MAX_VALUE) {
                    nowValue = temp.val;
                } else {
                    difference = Math.min(difference, temp.val - nowValue);
                    nowValue = temp.val;
                    if (difference == 1) {
                        return;
                    }
                }
            }
        }
    }

    private static void recursiveMethod(TreeNode root) {
        if (root == null) {
            return;
        }
        recursiveMethod(root.left);
        if (nowValue == Integer.MAX_VALUE) {
            nowValue = root.val;
        } else {
            difference = Math.min(difference, root.val - nowValue);
            nowValue = root.val;
            if (difference == 1) {
                return;
            }
        }
        recursiveMethod(root.right);
    }


}
