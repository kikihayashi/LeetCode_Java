package Leetcode;

/**
 * https://leetcode.com/problems/trim-a-binary-search-tree/
 */

public class L669_M_TrimaBinarySearchTree {

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

        TreeNode test = new TreeNode(3,
                new TreeNode(0, null, new TreeNode(2, new TreeNode(1), null)),
                new TreeNode(4));

//        TreeNode test = new TreeNode(4,
//                null,
//                new TreeNode(7,
//                        new TreeNode(6, new TreeNode(5), null),
//                        new TreeNode(8, null, new TreeNode(9))));

        int low = 1;
        int high = 3;
        test = trimBST(test, low, high);
        System.out.println(test);
    }


    //1ms、39.9MB
    public static TreeNode trimBST(TreeNode root, int low, int high) {
        /**
         * recursiveMethod
         * */
        return recursiveMethod(root, low, high);
    }

    private static TreeNode recursiveMethod(TreeNode curr, int low, int high) {
        if (curr == null) {
            return null;
        }
        if (curr.val > high || curr.val < low) {
            TreeNode newNode = deleteNode(curr, curr.val);
            return recursiveMethod(newNode, low, high);
        }
        curr.left = recursiveMethod(curr.left, low, high);
        curr.right = recursiveMethod(curr.right, low, high);
        return curr;
    }

    private static TreeNode deleteNode(TreeNode curr, int key) {
        if (curr == null) {
            return null;
        }
        if (curr.val > key) {
            curr.left = deleteNode(curr.left, key);
        } else if (curr.val < key) {
            curr.right = deleteNode(curr.right, key);
        } else {
            if (curr.left == null && curr.right == null) {
                return null;
            } else if (curr.left != null && curr.right == null) {
                return curr.left;
            } else if (curr.left == null && curr.right != null) {
                return curr.right;
            } else {
                return getMaxNode(curr.left, curr.right);
            }
        }
        return curr;
    }

    private static TreeNode getMaxNode(TreeNode rootLeft, TreeNode rootRight) {
        if (rootLeft == null) {
            return rootRight;
        }
        if (rootRight == null) {
            return rootLeft;
        }
        TreeNode fixNode = rootLeft;
        while (rootLeft.right != null) {
            rootLeft = rootLeft.right;
        }
        rootLeft.right = rootRight;
        return fixNode;
    }

    //別人寫的0ms、42.2MB
    public TreeNode trimBST2(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        if (root.val < low) {
            return trimBST2(root.right, low, high);
        }
        if (root.val > high) {
            return trimBST2(root.left, low, high);
        }
        root.left = trimBST2(root.left, low, high);
        root.right = trimBST2(root.right, low, high);
        return root;
    }

}
