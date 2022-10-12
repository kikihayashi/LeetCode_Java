package Leetcode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/sum-of-left-leaves/
 */

public class L404_E_SumofLeftLeaves {

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

//        TreeNode test = new TreeNode(8);

        TreeNode test = new TreeNode(37,
                new TreeNode(-34, null, new TreeNode(-100)),
                new TreeNode(-48, new TreeNode(-100), new TreeNode(48,
                        new TreeNode(-54, new TreeNode(-71),
                                new TreeNode(-22, null, new TreeNode(8))), null)));
//
//        TreeNode test = new TreeNode(1,
//                new TreeNode(2, new TreeNode(4), new TreeNode(5)),
//                new TreeNode(3));

//        TreeNode test = new TreeNode(8,
//                new TreeNode(3, new TreeNode(1), new TreeNode(6, new TreeNode(4), new TreeNode(7))),
//                new TreeNode(10, null, new TreeNode(14, new TreeNode(13), null)));

//        TreeNode test = new TreeNode(8,
//                new TreeNode(3, null, new TreeNode(6, new TreeNode(4), null)),
//                new TreeNode(10, null, new TreeNode(14, new TreeNode(13), null)));

//        TreeNode test = new TreeNode(8,
//                new TreeNode(3, new TreeNode(1), null),
//                new TreeNode(10, null, new TreeNode(14, new TreeNode(13), null)));

        System.out.println("ans:" + sumOfLeftLeaves(test));

    }

    public static int sum;

    public static int sumOfLeftLeaves(TreeNode root) {
        sum = 0;
        /**
         *  recursiveMethod
         */
        recursiveMethod(root);
        /**
         *  iterativeMethod
         */
//        iterativeMethod(root);
        return sum;
    }

    private static void recursiveMethod(TreeNode root) {
        if (root== null) {
            return;
        }
        recursiveMethod(root.left);
        recursiveMethod(root.right);
        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum += root.left.val;
        }
    }

    private static void iterativeMethod(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);

        while (!stack.isEmpty()) {
            TreeNode currentNode = stack.pop();
            if (currentNode != null) {
                System.out.println(currentNode.val);
                if (currentNode.right != null) {
                    stack.add(currentNode.right);
                }
                if (currentNode.left != null) {
                    stack.add(currentNode.left);
                    if (currentNode.left.right == null && currentNode.left.left == null) {
                        sum += currentNode.left.val;
                    }
                }
                stack.add(currentNode);
                stack.add(null);
            } else {
                stack.pop();
            }
        }
        return;
    }


}
