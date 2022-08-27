package LeetCode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class L515_M_FindLargestValueinEachTreeRow {

    /**
     * https://leetcode.com/problems/find-largest-value-in-each-tree-row/
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

        System.out.println(largestValues(test));
    }

    public static List<Integer> list;

    public static List<Integer> largestValues(TreeNode root) {
        list = new LinkedList<>();
//        iterativeMethod(root);
        recursiveMethod(root, 0);
        return list;
    }

    private static void iterativeMethod(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            int maxValue = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                maxValue = Math.max(maxValue, currentNode.val);
            }
            list.add(maxValue);
        }
        return;
    }

    private static void recursiveMethod(TreeNode root, int level) {
        if (root == null) {
            return;
        }

        level++;

        if (list.size() < level) {
            list.add(root.val);
        } else {
            list.set(level - 1, Math.max(root.val, list.get(level - 1)));
        }
        recursiveMethod(root.left, level);
        recursiveMethod(root.right, level);
        return;
    }

}
