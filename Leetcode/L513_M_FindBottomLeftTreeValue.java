package Leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/find-bottom-left-tree-value/
 */

public class L513_M_FindBottomLeftTreeValue {

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

        System.out.println("ans:" + findBottomLeftValue(test));

    }

    public static int bottomLeftValue;
    public static List<List<Integer>> finalList;

    public static int findBottomLeftValue(TreeNode root) {
        bottomLeftValue = 0;
        finalList = new LinkedList<>();
        /**
         *  recursiveMethod
         */
        recursiveMethod(root, 0);
        System.out.println(finalList);
        /**
         *  iterativeMethod
         */
        iterativeMethod(root);
        return bottomLeftValue;
    }

    private static void recursiveMethod(TreeNode root, int deep) {
        if (root == null) {
            bottomLeftValue = finalList.get(finalList.size() - 1).get(0);
            return;
        }
        deep++;
        if (finalList.size() < deep) {
            List<Integer> list = new LinkedList<>();
            finalList.add(list);
        }
        finalList.get(deep - 1).add(root.val);
        recursiveMethod(root.left, deep);
        recursiveMethod(root.right, deep);
    }

    private static void iterativeMethod(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();
                if (i == 0) {
                    bottomLeftValue = currentNode.val;
                }
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
        }
        return;
    }
}
