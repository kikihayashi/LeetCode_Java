package LeetCode;

import java.util.*;

public class L104_E_MaximumDepthofBinaryTree {

    /**
     * https://leetcode.com/problems/maximum-depth-of-binary-tree/
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

//        TreeNode test = new TreeNode(1,
//                new TreeNode(2, null, new TreeNode(4)),
//                new TreeNode(2, new TreeNode(4), null));

        TreeNode test = new TreeNode(1, new TreeNode(2, null, new TreeNode(4, new TreeNode(7),
                new TreeNode(8, new TreeNode(11), null))), new TreeNode(3, new TreeNode(5,
                new TreeNode(9), null), new TreeNode(6, new TreeNode(10), null)));

        System.out.println(maxDepth(test));
    }

    //2 ms、40.4 MB
    public static int maxDepth(TreeNode root) {
        int depth = 0;
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode currentRoot = queue.poll();
                if (currentRoot.left != null) {
                    queue.offer(currentRoot.left);
                }
                if (currentRoot.right != null) {
                    queue.offer(currentRoot.right);
                }
            }
            depth++;
        }
        return depth;
    }

    //8 ms、40.6 MB
    public static int maxDepth3(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Stack<TreeNode> stack = new Stack<>();
        Map<TreeNode, Integer> map = new HashMap<>();
        int depth = 1;
        int maxDepth = depth;

        stack.add(root);
        map.put(root, depth);
        root = root.left;

        while (true) {
            if (root != null) {
                depth++;
                map.put(root, depth);
                stack.add(root);
                root = root.left;
            } else {
                if (stack.size() > 0) {
                    depth = map.get(stack.peek());
                    maxDepth = (depth > maxDepth) ? depth : maxDepth;
                    root = stack.pop().right;
                } else {
                    return maxDepth;
                }
            }
        }
    }

    //別人寫的：https://leetcode.com/problems/maximum-depth-of-binary-tree/discuss/1597028/Java-Simplest-solution-Faster-than-100
    public int maxDepth2(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(maxDepth(node.left) + 1, maxDepth(node.right) + 1);
    }
}
