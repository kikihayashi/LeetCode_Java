package Leetcode;

import java.util.*;

public class L107_M_BinaryTreeLevelOrderTraversalII {

    /**
     * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
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
        TreeNode test = new TreeNode(1, new TreeNode(2, null, new TreeNode(4,
                new TreeNode(7), new TreeNode(8, new TreeNode(11), null))), new TreeNode(3, new TreeNode(5,
                new TreeNode(9), null), new TreeNode(6, null, new TreeNode(10))));

//        TreeNode test = new TreeNode(1,
//                new TreeNode(2, null, new TreeNode(7)),
//                new TreeNode(2, new TreeNode(7), null));
//
//        TreeNode test = new TreeNode(1,
//                new TreeNode(2,
//                        new TreeNode(3,
//                                new TreeNode(4,
//                                        new TreeNode(5), null), null), null), null);

        System.out.println(levelOrderBottom(test));
    }

    public static LinkedList<List<Integer>> resultList;

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        resultList = new LinkedList<>();

        /**
         * iterativeMethod
         * */
        iterativeMethod(root);

        /**
         * recursiveMethod
         * */

//        recursiveMethod(root, 0);

        return resultList;
    }

    //別人寫的
    private static void recursiveMethod(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        level++;

        if (resultList.size() < level) {
            List<Integer> levelList = new LinkedList<>();
            resultList.addFirst(levelList);
        }
        resultList.get(resultList.size() - level).add(root.val);
        recursiveMethod(root.left, level);
        recursiveMethod(root.right, level);
        return;
    }

    //別人寫的
    private static void iterativeMethod(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (queue.peek() != null) {
            List<Integer> levelList = new LinkedList<>();
            int size = queue.size();
            while (size > 0) {
                TreeNode currentNode = queue.poll();
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
                levelList.add(currentNode.val);
                size--;
            }
            resultList.addFirst(levelList);
        }
        return;
    }
}
