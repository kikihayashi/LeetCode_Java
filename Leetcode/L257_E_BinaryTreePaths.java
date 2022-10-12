package Leetcode;

import java.util.*;

public class L257_E_BinaryTreePaths {

    /**
     * https://leetcode.com/problems/binary-tree-paths/
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

//        TreeNode test = new TreeNode();

//        TreeNode test = new TreeNode(1, new TreeNode(2), new TreeNode(3));

//        TreeNode test = new TreeNode(1, new TreeNode(2, new TreeNode(3, new TreeNode(4), null), null), null);

//        TreeNode test = new TreeNode(1, null, new TreeNode(2, new TreeNode(3, null, new TreeNode(4)), null));

        TreeNode test = new TreeNode(8,
                new TreeNode(3, new TreeNode(1), new TreeNode(6, new TreeNode(4), new TreeNode(7))),
                new TreeNode(10, null, new TreeNode(14, new TreeNode(13), null)));

//        TreeNode test = new TreeNode(1, new TreeNode(2, null, new TreeNode(4,
//                new TreeNode(7), new TreeNode(8, new TreeNode(11), null))), new TreeNode(3, new TreeNode(5,
//                new TreeNode(9), null), new TreeNode(6, null, new TreeNode(10))));

        System.out.println(binaryTreePaths(test));
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> answer = new ArrayList<String>();
        if (root != null) searchBT(root, "", answer);
        return answer;
    }
    private static void searchBT(TreeNode root, String path, List<String> answer) {
        if (root.left == null && root.right == null) answer.add(path + root.val);
        if (root.left != null) searchBT(root.left, path + root.val + "->", answer);
        if (root.right != null) searchBT(root.right, path + root.val + "->", answer);
    }

    

    public static StringBuilder sb;
    public static List<String> list;
    public static Stack<TreeNode> stack;

//    public static List<String> binaryTreePaths(TreeNode root) {
//        list = new LinkedList<>();
//        sb = new StringBuilder();
//        stack = new Stack<>();
//
//        recursiveMethod(root);
//        return list;
//    }
//
//    private static void recursiveMethod(TreeNode root) {
//        if (root.right == null && root.left == null) {
//            return;
//        }
//        while (root.left != null) {
//            sb.append(root.val);
//            sb.append("->");
//        }
//        sb = sb.deleteCharAt(sb.length() - 1);
//        list.add(sb.toString());
//        sb = sb.deleteCharAt(sb.length() - 1);
//        recursiveMethod(root);
//    }

}
