package LeetCode;

import java.util.*;

/**
 * https://leetcode.com/problems/maximum-binary-tree/
 */

public class L654_M_MaximumBinaryTree {

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
        int[] test = new int[]{3, 2, 1, 6, 0, 5};
        System.out.println(constructMaximumBinaryTree(test));
    }

    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        return recursiveMethod(nums, 0, nums.length - 1);
    }

    private static TreeNode recursiveMethod(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int[] rootInfo = getMaxValue(nums, start, end);
        int index = rootInfo[0];
        int rootValue = rootInfo[1];
        TreeNode leftNode = recursiveMethod(nums, start, index - 1);
        TreeNode rightNode = recursiveMethod(nums, index + 1, end);
        return new TreeNode(rootValue, leftNode, rightNode);
    }

    private static int[] getMaxValue(int[] nums, int start, int end) {
        int maxIndex = start;
        int maxValue = nums[start];
        for (int i = start + 1; i <= end; i++) {
            if (nums[i] > maxValue) {
                maxValue = nums[i];
                maxIndex = i;
            }
        }
        return new int[]{maxIndex, maxValue};
    }

    public static Map<Integer, Integer> map;

    public static TreeNode constructMaximumBinaryTree2(int[] nums) {
        map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        TreeNode temp = recursiveMethod2(nums, 0, nums.length - 1);
        return temp;
    }

    private static TreeNode recursiveMethod2(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int[] array = Arrays.copyOfRange(nums, start, end + 1);
        int rootValue = getMaxValue2(array);
        int index = map.get(rootValue);
        TreeNode leftNode = recursiveMethod2(nums, start, index - 1);
        TreeNode rightNode = recursiveMethod2(nums, index + 1, end);
        return new TreeNode(rootValue, leftNode, rightNode);
    }

    private static int getMaxValue2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length - 1];
    }


}
