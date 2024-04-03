package LeetCode;

/**
 * https://leetcode.com/problems/delete-node-in-a-bst/
 */

public class L450_M_DeleteNodeinaBST {

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

        TreeNode test = new TreeNode(4,
                null,
                new TreeNode(7,
                        new TreeNode(6, new TreeNode(5), null),
                        new TreeNode(8, null, new TreeNode(9))));

        int val = 7;
        test = deleteNode(test, val);
        System.out.println(test);
    }

    public static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        /**
         * iterativeMethod
         * */
        return iterativeMethod(root, key);
        /**
         * recursiveMethod
         * */
//        return recursiveMethod(root, key);
    }

    private static TreeNode recursiveMethod(TreeNode curr, int key) {
        if (curr == null) {
            return null;
        }
        if (curr.val > key) {
            curr.left = recursiveMethod(curr.left, key);
        } else if (curr.val < key) {
            curr.right = recursiveMethod(curr.right, key);
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

    private static TreeNode iterativeMethod(TreeNode root, int key) {
        TreeNode curr = root;
        TreeNode prev = null;
        if (root.val == key && (root.left != null || root.right != null)) {
            return getMaxNode(root.left, root.right);
        }

        while (root != null) {
            if (key > root.val) {
                prev = root;
                root = root.right;
            } else if (key < root.val) {
                prev = root;
                root = root.left;
            } else {
                TreeNode temp;
                if (root.left == null && root.right == null) {
                    if (prev == null) {
                        return null;
                    }
                    temp = null;
                } else if (root.left != null && root.right == null) {
                    temp = root.left;
                } else if (root.left == null && root.right != null) {
                    temp = root.right;
                } else {
                    temp = getMaxNode(root.left, root.right);
                }
                if (prev.left == root) {
                    prev.left = temp;
                } else {
                    prev.right = temp;
                }
                break;
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

}
