package Leetcode;

/**
 * https://leetcode.com/problems/binary-tree-tilt/
 */

public class L563_E_BinaryTreeTilt {

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

//        TreeNode test = new TreeNode(4,
//                new TreeNode(2, new TreeNode(3), new TreeNode(5)),
//                new TreeNode(9, null, new TreeNode(7)));
//
//        TreeNode test = new TreeNode(1,
//                new TreeNode(2, new TreeNode(3), new TreeNode(4)),
//                null);

//        TreeNode test = new TreeNode(1, new TreeNode(2), new TreeNode(3));

        TreeNode test = new TreeNode(21,
                new TreeNode(7, new TreeNode(1), new TreeNode(1, new TreeNode(3), new TreeNode(3))),
                new TreeNode(14, new TreeNode(2), new TreeNode(2)));

//        TreeNode test = new TreeNode(-8,
//                new TreeNode(3, new TreeNode(-8, null, new TreeNode(-1, null, new TreeNode(8))), null),
//                new TreeNode(0));

        System.out.println("ans:" + findTilt(test));
    }

    private static int resultValue;

    public static int findTilt(TreeNode root) {
        resultValue = 0;
        /**
         *  recursiveMethod
         */
        recursiveMethod(root);
        return resultValue;
    }

    private static int recursiveMethod(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSum = recursiveMethod(root.left);
        int rightSum = recursiveMethod(root.right);
        resultValue += Math.abs(leftSum - rightSum);

        return root.val + leftSum + rightSum;
    }
}
