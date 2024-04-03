package LeetCode;

/**
 * https://leetcode.com/problems/search-in-a-binary-search-tree/
 */

public class L700_E_SearchinaBinarySearchTree {

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
                new TreeNode(7, null, null));

        int n = 5;
        System.out.println(searchBST(test, n));
    }

    public static TreeNode searchBST(TreeNode root, int val) {
        /**
         * iterativeMethod
         */
        return iterativeMethod(root, val);

        /**
         * recursiveMethod
         */
//        return recursiveMethod(root, val);
    }

    private static TreeNode iterativeMethod(TreeNode root, int val) {
        while (root != null) {
            if (root.val == val) {
                return root;
            }
            if (root.val > val) {
                root = root.left;
                continue;
            }
            if (root.val < val) {
                root = root.right;
                continue;
            }
        }
        return null;
    }

    private static TreeNode recursiveMethod(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        if (root.val > val) {
            return recursiveMethod(root.left, val);
        }
        if (root.val < val) {
            return recursiveMethod(root.right, val);
        }
        return null;
    }


}
