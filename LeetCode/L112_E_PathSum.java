package LeetCode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/path-sum/
 */

public class L112_E_PathSum {

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

//        TreeNode test = new TreeNode(8,new TreeNode(7),null);

//        TreeNode test = new TreeNode(8,
//                new TreeNode(3, new TreeNode(1), new TreeNode(6, new TreeNode(4), new TreeNode(7))),
//                new TreeNode(10, null, new TreeNode(14, new TreeNode(13), null)));

//        TreeNode test = new TreeNode(8,
//                new TreeNode(3, null, new TreeNode(6, new TreeNode(4), null)),
//                new TreeNode(10, null, new TreeNode(14, new TreeNode(13), null)));

//        TreeNode test = new TreeNode(8,
//                new TreeNode(3, new TreeNode(1), null),
//                new TreeNode(10, null, new TreeNode(14, new TreeNode(13), null)));

        int n = -88;
        System.out.println("ans:" + hasPathSum(test, n));

    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        /**
         *  recursiveMethod
         */
        return recursiveMethod(root, targetSum, root.val);
        /**
         *  iterativeMethod
         */
//        return iterativeMethod(root, targetSum);
    }

    private static boolean iterativeMethod(TreeNode root, int targetSum) {
        Stack<Object> stack = new Stack<>();
        stack.add(root);
        stack.add(root.val);
        while (!stack.isEmpty()) {
            int currentSum = (Integer) stack.pop();
            TreeNode currentNode = (TreeNode) stack.pop();
            if (currentNode.left == null && currentNode.right == null) {
                if (targetSum == currentSum) {
                    return true;
                }
            }
            if (currentNode.right != null) {
                stack.add(currentNode.right);
                stack.add(currentSum + currentNode.right.val);
            }
            if (currentNode.left != null) {
                stack.add(currentNode.left);
                stack.add(currentSum + currentNode.left.val);
            }
        }
        return false;
    }

    private static boolean recursiveMethod(TreeNode root, int targetSum, int pathSum) {
        boolean resultLeft = false;
        boolean resultRight = false;

        if (root.left == null && root.right == null) {
            if (pathSum == targetSum) {
                return true;
            }
        }
        if (root.left != null) {
            resultLeft = recursiveMethod(root.left, targetSum, pathSum + root.left.val);
        }
        if (root.right != null) {
            resultRight = recursiveMethod(root.right, targetSum, pathSum + root.right.val);
        }
        return resultLeft || resultRight;
    }

}
