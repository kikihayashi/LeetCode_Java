package Leetcode;

/**
 * https://leetcode.com/problems/insert-into-a-binary-search-tree/
 */

public class L701_M_InsertintoaBinarySearchTree {

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
        TreeNode test = new TreeNode(4,
                new TreeNode(2, new TreeNode(1), new TreeNode(3)),
                new TreeNode(7));

        int val = 5;
        test = insertIntoBST(test, val);
        System.out.println(test);
    }

    public static TreeNode finalRoot;

    public static TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        finalRoot = root;
        /**
         * iterativeMethod
         * */
//        iterativeMethod(root, val);
        /**
         * recursiveMethod
         * */
        recursiveMethod(root, null, val);
        return finalRoot;

    }

    private static void iterativeMethod(TreeNode root, int val) {
        TreeNode curr = root;
        TreeNode prev = null;
        TreeNode insertNode = new TreeNode(val);

        while (curr != null) {
            prev = curr;
            if (val > curr.val) {
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }
        if (prev.val > val) {
            prev.left = insertNode;
        } else {
            prev.right = insertNode;
        }
    }

    private static void recursiveMethod(TreeNode curr, TreeNode prev, int val) {
        if (curr == null) {
            if (prev.val > val) {
                prev.left = new TreeNode(val);
            } else {
                prev.right = new TreeNode(val);
            }
            return;
        }
        if (curr.val > val) {
            recursiveMethod(curr.left, curr, val);
        } else {
            recursiveMethod(curr.right, curr, val);
        }
    }
}
