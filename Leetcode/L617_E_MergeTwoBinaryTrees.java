package Leetcode;

public class L617_E_MergeTwoBinaryTrees {

    /**
     * https://leetcode.com/problems/merge-two-binary-trees/
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

        TreeNode test1 = new TreeNode(1, new TreeNode(2, null, new TreeNode(4)), new TreeNode(2, new TreeNode(4), null));

        TreeNode test2 = new TreeNode(1, new TreeNode(2, null, new TreeNode(4, new TreeNode(7),
                new TreeNode(8, new TreeNode(11), null))), new TreeNode(3, new TreeNode(5,
                new TreeNode(9), null), new TreeNode(6, new TreeNode(10), null)));

        System.out.println(mergeTrees(test1, test2));
    }

    //0 ms、39.1 MB
    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }
        if (root2 == null) {
            return root1;
        }
        if (root1 == null) {
            return root2;
        }
        return new TreeNode(root1.val + root2.val,
                mergeTrees(root1.left, root2.left),
                mergeTrees(root1.right, root2.right));
    }

    //0 ms、39.7 MB
    public static TreeNode mergeTrees2(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        } else if (root1 != null && root2 == null) {
            return root1;
        } else if (root2 != null && root1 == null) {
            return root2;
        } else {
            return new TreeNode(root1.val + root2.val,
                    mergeTrees(root1.left, root2.left),
                    mergeTrees(root1.right, root2.right));
        }
    }

    //0 ms、38.8 MB
    public static TreeNode mergeTrees3(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }
        if (root2 == null) {
            return root1;
        }
        if (root1 == null) {
            return root2;
        }
        TreeNode combineNode = new TreeNode(root1.val + root2.val);
        combineNode.left = mergeTrees(root1.left, root2.left);
        combineNode.right = mergeTrees(root1.right, root2.right);
        return combineNode;
    }



}
