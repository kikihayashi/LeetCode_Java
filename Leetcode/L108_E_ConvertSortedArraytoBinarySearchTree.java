package Leetcode;

import java.util.Arrays;

public class L108_E_ConvertSortedArraytoBinarySearchTree {

    /**
     * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
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

        int[] test = new int[]{-10, -3, 0, 5, 9};


        System.out.println(sortedArrayToBST(test));
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 1) {
            return new TreeNode(nums[0]);
        }
        if (nums.length == 2) {
            return new TreeNode(nums[0], null, new TreeNode(nums[1]));
        }
        TreeNode currentNode = new TreeNode(nums[nums.length / 2]);

        currentNode.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, nums.length / 2));
        currentNode.right = sortedArrayToBST(Arrays.copyOfRange(nums, nums.length / 2 + 1, nums.length));
        return currentNode;
    }
}
