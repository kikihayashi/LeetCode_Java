package LeetCode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/validate-binary-search-tree/
 */

public class L98_M_ValidateBinarySearchTree {

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

//        TreeNode test = new TreeNode(3,
//                new TreeNode(1, new TreeNode(0), new TreeNode(2)),
//                new TreeNode(5, new TreeNode(4), new TreeNode(6)));//true

        TreeNode test = new TreeNode(5,
                new TreeNode(4),
                new TreeNode(6, new TreeNode(3), new TreeNode(7)));//false

//        TreeNode test = new TreeNode(5,
//                new TreeNode(1),
//                new TreeNode(4, new TreeNode(3), new TreeNode(6)));//false

        System.out.println(isValidBST(test));
    }

    public static int nowValue;
    public static boolean isFirstTime;

    public static boolean isValidBST(TreeNode root) {
        nowValue = 0;
        isFirstTime = true;
        /**
         * iterativeMethod
         */
//        return iterativeMethod(root);

        /**
         * recursiveMethod
         */
        return recursiveMethod(root);
    }

    private static boolean iterativeMethod(TreeNode root) {
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
                if (isFirstTime) {
                    nowValue = temp.val;
                    isFirstTime = false;
                } else {
                    if (nowValue >= temp.val) {
                        return false;
                    } else {
                        nowValue = temp.val;
                    }
                }
            }
        }
        return true;
    }

    private static boolean recursiveMethod(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean leftResult = recursiveMethod(root.left);
        if (isFirstTime) {
            nowValue = root.val;
            isFirstTime = false;
        } else {
            if (root.val <= nowValue) {
                return false;
            } else {
                nowValue = root.val;
            }
        }
        boolean rightResult = recursiveMethod(root.right);
        return leftResult && rightResult;
    }


}
