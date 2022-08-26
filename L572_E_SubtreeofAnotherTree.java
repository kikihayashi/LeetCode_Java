package LeetCode;

import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class L572_E_SubtreeofAnotherTree {

    /**
     * https://leetcode.com/problems/subtree-of-another-tree/
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
//        TreeNode test = new TreeNode(1, new TreeNode(2, null, new TreeNode(4,
//                new TreeNode(7), new TreeNode(8, new TreeNode(11), null))), new TreeNode(3, new TreeNode(5,
//                new TreeNode(9), null), new TreeNode(6, null, new TreeNode(10))));

//        TreeNode test = new TreeNode(1,
//                new TreeNode(2, null, new TreeNode(7)),
//                new TreeNode(2, new TreeNode(7), null));

        TreeNode test = new TreeNode(1, new TreeNode(2, null, new TreeNode(3)),
                new TreeNode(2, null, new TreeNode(3)));

        TreeNode test2 = new TreeNode(2, null, new TreeNode(3));

        System.out.println(isSubtree(test, test2));
    }



    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        /**
         * iterativeMethod
         **/
        return iterativeMethod(root, subRoot);

        /**
         * recursiveMethod
         **/
//        return recursiveMethod(root, subRoot);
    }

    private static boolean recursiveMethod(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        if (root.val == subRoot.val && isSameTree(root, subRoot)) {
            return true;
        }
        return recursiveMethod(root.left, subRoot) || recursiveMethod(root.right, subRoot);
    }

    public static boolean iterativeMethod(TreeNode root, TreeNode subRoot) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode currentNode = stack.pop();
            if (currentNode != null) {
                if (currentNode.right != null) {
                    stack.push(currentNode.right);
                }
                stack.push(currentNode);
                stack.push(null);
                if (currentNode.left != null) {
                    stack.push(currentNode.left);
                }
            } else {
                TreeNode nowNode = stack.pop();
                if (nowNode.val == subRoot.val && isSameTree(nowNode, subRoot)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isSameTree(TreeNode leftRoot, TreeNode rightRoot) {
        //如果左右節點都是空，回傳true
        if (leftRoot == null && rightRoot == null) {
            return true;
        }
        //如果左右節點不為空，且左右節點相同，將左節點的左方與右節點的左方遞迴帶入計算、左節點的右方與右節點的右方遞迴帶入計算。
        if ((leftRoot != null && rightRoot != null) && (leftRoot.val == rightRoot.val)) {
            return isSameTree(leftRoot.left, rightRoot.left) &&
                    isSameTree(leftRoot.right, rightRoot.right);
        }
        //其他情況回傳false
        else {
            return false;
        }
    }


}
