package LeetCode;

import java.util.*;

/**
 * https://leetcode.com/problems/path-sum-ii/
 */

public class L113_M_PathSumII {

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

        TreeNode test = new TreeNode(37,
                new TreeNode(-34, null, new TreeNode(-100)),
                new TreeNode(-48, new TreeNode(-100), new TreeNode(48,
                        new TreeNode(-54, new TreeNode(-71),
                                new TreeNode(-22, null, new TreeNode(8))), null)));

//        TreeNode test = new TreeNode(8,new TreeNode(7),null);

//        TreeNode test = new TreeNode(8,
//                new TreeNode(3, new TreeNode(1), new TreeNode(6, new TreeNode(4), new TreeNode(7))),
//                new TreeNode(10, null, new TreeNode(14, new TreeNode(13), null)));

//        TreeNode test = new TreeNode(8,
//                new TreeNode(3, null, new TreeNode(6, new TreeNode(4), null)),
//                new TreeNode(10, null, new TreeNode(14, new TreeNode(13), null)));

//        TreeNode test = new TreeNode(8,
//                new TreeNode(3, new TreeNode(1), null),
//                new TreeNode(10, null, new TreeNode(14, new TreeNode(13), null)));

        int n = -88;

        pathSum(test, n);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public static List<List<Integer>> list;

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        list = new LinkedList<>();
        if (root == null) {
            return list;
        }
        /**
         *  recursiveMethod
         */
        recursiveMethod(root, targetSum, root.val, new LinkedList<>());
        /**
         *  iterativeMethod
         */
//        iterativeMethod(root, targetSum);
        return list;
    }

    private static void iterativeMethod(TreeNode root, int targetSum) {
        Stack<Object> stack = new Stack<>();
        List<Integer> nodeList = new LinkedList<>();
        stack.add(root);
        nodeList.add(root.val);
        stack.add(nodeList);
        stack.add(root.val);
        while (!stack.isEmpty()) {
            int pathSum = (int) stack.pop();
            List<Integer> currentList = (List<Integer>) stack.pop();
            TreeNode currentNode = (TreeNode) stack.pop();
            if (currentNode.left == null && currentNode.right == null) {
                if (targetSum == pathSum) {
                    list.add(currentList);
                }
            }
            if (currentNode.right != null) {
                stack.add(currentNode.right);
                List<Integer> temp = new LinkedList<>(currentList);
                temp.add(currentNode.right.val);
                stack.add(temp);
                stack.add(pathSum + currentNode.right.val);
            }
            if (currentNode.left != null) {
                stack.add(currentNode.left);
                List<Integer> temp = new LinkedList<>(currentList);
                temp.add(currentNode.left.val);
                stack.add(temp);
                stack.add(pathSum + currentNode.left.val);
            }
        }
    }

    private static void recursiveMethod(TreeNode root, int targetSum, int pathSum, List<Integer> pathList) {
        pathList.add(root.val);

        if (root.left == null && root.right == null) {
            if (pathSum == targetSum) {
                List<Integer> temp = new LinkedList<>(pathList);
                list.add(temp);
            }
            return;
        }
        if (root.left != null) {
            recursiveMethod(root.left, targetSum, pathSum + root.left.val, pathList);
            pathList.remove(pathList.size() - 1);
        }
        if (root.right != null) {
            recursiveMethod(root.right, targetSum, pathSum + root.right.val, pathList);
            pathList.remove(pathList.size() - 1);
        }
    }

}
