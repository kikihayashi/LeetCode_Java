package Leetcode;

/**
 * https://leetcode.com/problems/construct-string-from-binary-tree/
 */

public class L606_E_ConstructStringfromBinaryTree {

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
//                new TreeNode(2, new TreeNode(4), null),
//                new TreeNode(3));

        TreeNode test = new TreeNode(1,
                new TreeNode(2, null, new TreeNode(4)),
                new TreeNode(3));

//        TreeNode test = new TreeNode(1, new TreeNode(2), new TreeNode(3));

//        TreeNode test = new TreeNode(21,
//                new TreeNode(7, new TreeNode(1), new TreeNode(1, new TreeNode(3), new TreeNode(3))),
//                new TreeNode(14, new TreeNode(2), new TreeNode(2)));

//        TreeNode test = new TreeNode(-8,
//                new TreeNode(3, new TreeNode(-8, null, new TreeNode(-1, null, new TreeNode(8))), null),
//                new TreeNode(0));

        System.out.println("ans:" + tree2str(test));
    }

    public static String tree2str(TreeNode root) {
        /**
         *  recursiveMethod
         */
        return recursiveMethod(root);
    }

    private static String recursiveMethod(TreeNode root) {
        if (root == null) {
            return "";
        }
        String leftStr = recursiveMethod(root.left);
        String rightStr = recursiveMethod(root.right);
        if (leftStr.length() > 0 && rightStr.length() == 0) {
            return root.val + "(" + leftStr + ")";
        } else if (leftStr.length() == 0 && rightStr.length() == 0) {
            return String.valueOf(root.val);
        } else {
            return root.val + "(" + leftStr + ")" + "(" + rightStr + ")";
        }
    }
}
