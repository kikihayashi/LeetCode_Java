package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class L222_M_CountCompleteTreeNodes {

    /**
     * https://leetcode.com/problems/count-complete-tree-nodes/
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

        TreeNode test = new TreeNode(1);

//        TreeNode test = new TreeNode(1, new TreeNode(2), null);

//        TreeNode test = new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3));

//        TreeNode test = new TreeNode(1,
//                new TreeNode(2, new TreeNode(3), new TreeNode(4)),
//                new TreeNode(2, new TreeNode(5), null));

//        TreeNode test = new TreeNode(1, new TreeNode(2, null, new TreeNode(4, new TreeNode(7),
//                new TreeNode(8, new TreeNode(11), null))), new TreeNode(3, new TreeNode(5,
//                new TreeNode(9), null), new TreeNode(6, new TreeNode(10), null)));

        System.out.println(countNodes(test));
    }

    //O(logN^2)
    public static int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        while (root != null) {
            int leftNodeLeftDepth = getDepth(Direction.Left, root.left);
            int leftNodeRightDepth = getDepth(Direction.Right, root.left);
            int rightNodeRightDepth = getDepth(Direction.Right, root.right);

            if (leftNodeLeftDepth == rightNodeRightDepth) {
                count += (1 << (leftNodeLeftDepth + 1)) - 1;//2^(leftNodeLeftDepth + 1) - 1
                break;
            }
            if (leftNodeLeftDepth > leftNodeRightDepth) {
                count += 1 << rightNodeRightDepth;//2^rightNodeRightDepth
                root = root.left;
            } else {
                count += 1 << leftNodeLeftDepth;//2^leftNodeLeftDepth
                root = root.right;
            }
        }
        return count;
    }

    private static int getDepth(Direction dir, TreeNode root) {
        int depth = 0;
        switch (dir) {
            case Left:
                while (root != null) {
                    root = root.left;
                    depth++;
                }
                break;
            case Right:
                while (root != null) {
                    root = root.right;
                    depth++;
                }
                break;
        }
        return depth;
    }

    enum Direction {
        Left, Right;
    }
}
