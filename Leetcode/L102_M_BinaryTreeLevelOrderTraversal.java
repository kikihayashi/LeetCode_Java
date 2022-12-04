package Leetcode;

import java.util.*;

public class L102_M_BinaryTreeLevelOrderTraversal {

    /**
     * https://leetcode.com/problems/binary-tree-level-order-traversal/
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

        System.out.println(levelOrder(test));
    }

    public static List<List<Integer>> resultList;

    public static List<List<Integer>> levelOrder(TreeNode root) {
        resultList = new LinkedList<>();

        /**
         * iterativeMethod
         * */
//        iterativeMethod(root);

        /**
         * recursiveMethod
         * */

        recursiveM(root, 0);
        return resultList;
    }

    private static void recursiveM(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        List<Integer> list = new LinkedList<>();
        if (level == resultList.size()) {
            resultList.add(list);
        }
        resultList.get(level).add(root.val);
        recursiveM(root.left, level + 1);
        recursiveM(root.right, level + 1);

    }


    //別人寫的
    private static void recursiveMethod(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        level++;

        if (resultList.size() < level) {
            List<Integer> levelList = new LinkedList<>();
            resultList.add(levelList);
        }
        resultList.get(level - 1).add(root.val);
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
                levelList.add(currentNode.val);
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
                size--;
            }
            resultList.add(levelList);
        }
        return;
    }

    public static List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> resultList = new LinkedList<>();
        if (root == null) {
            return resultList;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);

        while (queue.peek() != null) {
            List<Integer> levelList = new LinkedList<>();
            while (queue.peek() != null) {
                TreeNode currentNode = queue.poll();
                levelList.add(currentNode.val);
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            resultList.add(levelList);
            queue.poll();
            queue.offer(null);
        }
        return resultList;
    }
}
