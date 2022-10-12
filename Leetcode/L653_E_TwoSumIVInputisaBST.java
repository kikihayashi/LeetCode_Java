package Leetcode;

import java.util.*;

public class L653_E_TwoSumIVInputisaBST {

    /**
     * https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
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

    public static List<Integer> lst = new LinkedList<>();


    public static void main(String[] args) {

        TreeNode test = new TreeNode(5,
                new TreeNode(3, new TreeNode(2), new TreeNode(4)),
                new TreeNode(6, null, new TreeNode(7)));

//        TreeNode test = new TreeNode(1);
//        TreeNode test = new TreeNode(2, null, new TreeNode(3));

        int n = 9;

        System.out.println(findTarget(test, n));
    }

    //別人寫的2 ms、39.9 MB
    public static boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        int start = 0;
        int end = list.size() - 1;

        while (start < end) {
            int sum = list.get(start) + list.get(end);
            if (sum < k) {
                start++;
            } else if (sum > k) {
                end--;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void inorder(TreeNode root, List list) {
        if (root == null) {
            return;
        }
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    //3 ms、40.7 MB Set
    public static boolean findTarget2(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>();
        return recursiveMethod(root, k, set);
    }

    public static boolean recursiveMethod(TreeNode root, int k, HashSet<Integer> set) {
        if (root != null) {
            if (set.contains(root.val)) {
                return true;
            }
            set.add(root.val);
            set.add(k - root.val);
            return recursiveMethod(root.left, k, set) || recursiveMethod(root.right, k, set);
        } else {
            return false;
        }
    }

}
