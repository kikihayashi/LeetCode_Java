package LeetCode;

public class L226_E_InvertBinaryTree {

    /**
     * https://leetcode.com/problems/invert-binary-tree/
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

//        TreeNode test = new TreeNode(1);

//        TreeNode test = new TreeNode(1,new TreeNode(2),new TreeNode(2));

        TreeNode test = new TreeNode(1,
                new TreeNode(2, null, new TreeNode(4)),
                new TreeNode(2, new TreeNode(4), null));

//        TreeNode test = new TreeNode(1, new TreeNode(2, null, new TreeNode(4, new TreeNode(7),
//                new TreeNode(8, new TreeNode(11), null))), new TreeNode(3, new TreeNode(5,
//                new TreeNode(9), null), new TreeNode(6, new TreeNode(10), null)));

        System.out.println(invertTree(test));
    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode leftNode = root.left;
        TreeNode rightNode = root.right;
        root.right = invertTree(leftNode);
        root.left = invertTree(rightNode);
        return root;
    }
}
