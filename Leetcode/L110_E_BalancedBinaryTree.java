package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class L110_E_BalancedBinaryTree {

    /**
     * https://leetcode.com/problems/balanced-binary-tree/
     */

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
        TreeNode test = new TreeNode(1, new TreeNode(2, null, new TreeNode(4,
                new TreeNode(7), new TreeNode(8, new TreeNode(11), null))), new TreeNode(3, new TreeNode(5,
                new TreeNode(9), null), new TreeNode(6, null, new TreeNode(10))));
//
//        TreeNode test = new TreeNode(1,
//                new TreeNode(2, null, new TreeNode(7)),
//                new TreeNode(2, new TreeNode(7), null));
//
//        TreeNode test = new TreeNode(1,
//                new TreeNode(2,
//                        new TreeNode(3,
//                                new TreeNode(4,
//                                        new TreeNode(5), null), null), null), null);

        System.out.println(isBalanced(test));
    }

    public static boolean isBalanced(TreeNode root) {
        /**
         * iterativeMethod
         * */
//        return iterativeMethod(root);
        /**
         * recursiveMethod
         * */
        return recursiveMethod(root);

        //別人寫的
//        return getHeight(root) == -1 ? false : true;
    }

    public static boolean recursiveMethod(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (Math.abs(getDepth(root.left) - getDepth(root.right)) > 1) {
            return false;
        }
        return recursiveMethod(root.left) && recursiveMethod(root.right);
    }

    public static boolean iterativeMethod(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();
                if (Math.abs(getDepth(currentNode.left) - getDepth(currentNode.right)) > 1) {
                    return false;
                }
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
        }
        return true;
    }

    private static int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        int depth = 1 + Math.max(leftDepth, rightDepth);
        return depth;
    }

    //別人寫的
    public static int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = getHeight(root.left);
        if (leftDepth == -1) {
            return -1;
        }
        int rightDepth = getHeight(root.right);
        if (rightDepth == -1) {
            return -1;
        }
        int difference = (Math.abs(leftDepth - rightDepth) > 1) ? -1 : Math.max(leftDepth, rightDepth) + 1;
        return difference;
    }


}
