package Leetcode;

import java.util.*;

public class L111_E_MinimumDepthofBinaryTree {

    /**
     * https://leetcode.com/problems/minimum-depth-of-binary-tree/
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

//        TreeNode test = new TreeNode(1,
//                new TreeNode(2, null, new TreeNode(4)),
//                new TreeNode(2, new TreeNode(4), null));
//
        TreeNode test = new TreeNode(1, new TreeNode(2, null, new TreeNode(4, new TreeNode(7),
                new TreeNode(8, new TreeNode(11), null))), new TreeNode(3, new TreeNode(5,
                new TreeNode(9), null), new TreeNode(6, new TreeNode(10), null)));

        System.out.println(minDepth(test));
    }

    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depth = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode currentRoot = queue.poll();
                if (currentRoot.left == null && currentRoot.right == null) {
                    return depth;
                }
                if (currentRoot.left != null) {
                    queue.offer(currentRoot.left);
                }
                if (currentRoot.right != null) {
                    queue.offer(currentRoot.right);
                }
            }
            depth++;
        }
        return depth;
    }
}
