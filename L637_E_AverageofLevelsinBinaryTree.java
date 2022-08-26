package LeetCode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class L637_E_AverageofLevelsinBinaryTree {

    /**
     * https://leetcode.com/problems/average-of-levels-in-binary-tree/
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

        System.out.println(averageOfLevels(test));
    }

    public static List<Double> resultList;

    public static List<Double> averageOfLevels(TreeNode root) {
        resultList = new LinkedList<>();
        if (root == null) {
            return resultList;
        }
        iterativeMethod(root);
        return resultList;
    }

    private static void iterativeMethod(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            double sum = 0;
            int number = size;
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
                sum += currentNode.val;
            }
            resultList.add(sum / number);
        }
        return;
    }
}
