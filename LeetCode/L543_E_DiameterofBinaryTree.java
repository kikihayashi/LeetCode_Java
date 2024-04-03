package LeetCode;

import java.util.Stack;

public class L543_E_DiameterofBinaryTree {

    /**
     * https://leetcode.com/problems/diameter-of-binary-tree/
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
//        TreeNode test = new TreeNode(1, null, new TreeNode(2));
//        TreeNode test = new TreeNode(1,new TreeNode(2, null, new TreeNode(4)),new TreeNode(2, new TreeNode(4), null));

        TreeNode test = new TreeNode(1, new TreeNode(2, null, new TreeNode(4, new TreeNode(7),
                new TreeNode(8, new TreeNode(11), null))), new TreeNode(3, new TreeNode(5,
                new TreeNode(9), null), new TreeNode(6, new TreeNode(10), null)));

        System.out.println(diameterOfBinaryTree(test));
    }

    //別人寫的：https://leetcode.com/problems/diameter-of-binary-tree/discuss/1589941/Java-easy-and-intuitive-solution-oror-Brute-and-optimised
    public static int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int diameter = maxDepth(root.left) + maxDepth(root.right);
        int diameterLeft = diameterOfBinaryTree(root.left);
        int diameterRight = diameterOfBinaryTree(root.right);

        return Math.max(diameter, Math.max(diameterLeft, diameterRight));
    }

    //自己寫的
    public static int diameterOfBinaryTree2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        int maxDiameter = maxDepth(root.right) + maxDepth(root.left);
        stack.add(root);
        TreeNode currentRoot = root.left;

        while (true) {
            if (currentRoot == null && stack.size() == 0) {
                break;
            }
            if (currentRoot != null) {
                int currentDiameter = maxDepth(currentRoot.right) + maxDepth(currentRoot.left);
                maxDiameter = (maxDiameter > currentDiameter) ? maxDiameter : currentDiameter;
                stack.add(currentRoot);
                currentRoot = currentRoot.left;
            } else {
                currentRoot = stack.pop().right;
            }
        }
        return maxDiameter;
    }


    //別人寫的：https://leetcode.com/problems/maximum-depth-of-binary-tree/discuss/1597028/Java-Simplest-solution-Faster-than-100
    public static int maxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(maxDepth(node.left) + 1, maxDepth(node.right) + 1);
    }


    //別人寫的：https://leetcode.com/problems/diameter-of-binary-tree/discuss/1589941/Java-easy-and-intuitive-solution-oror-Brute-and-optimised








}
