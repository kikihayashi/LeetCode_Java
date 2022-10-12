package Leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class L199_M_BinaryTreeRightSideView {

    /**
     * https://leetcode.com/problems/binary-tree-right-side-view/
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

        System.out.println(rightSideView(test));
    }

    public static List<Integer> rightList;
    public static List<List<Integer>> list;

    public static List<Integer> rightSideView(TreeNode root) {
        list = new LinkedList<>();
        rightList = new LinkedList<>();
        if (root == null) {
            return rightList;
        }
        levelOrder(root);
        for (List<Integer> levelList : list) {
            rightList.add(levelList.get(0));
        }
        return rightList;
    }

    private static void levelOrder(TreeNode root) {
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
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                levelList.add(currentNode.val);
                size--;
            }
            list.add(levelList);
        }
        return;
    }

    private static void levelOrder(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        level++;
        if (list.size() < level) {
            List<Integer> levelList = new LinkedList<>();
            list.add(levelList);
        }
        list.get(level - 1).add(root.val);
        levelOrder(root.right, level);
        levelOrder(root.left, level);
        return;
    }


}
