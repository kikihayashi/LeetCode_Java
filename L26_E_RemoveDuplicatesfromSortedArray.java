package LeetCode;

import java.util.Arrays;

public class L26_E_RemoveDuplicatesfromSortedArray {

    /**
     * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
     */

    public static void main(String[] args) {
//        int[] nums = new int[]{};
//        int[] nums = new int[]{1};
//        int[] nums = new int[]{1, 1, 2};
//        int[] nums = new int[]{1, 2, 3};
        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int tempNumber = nums[0];
        int tempIndex = 1;
        int length = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != tempNumber) {
                tempNumber = nums[i];
                nums[tempIndex] = tempNumber;
                tempIndex++;
                length++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return length;
    }
}
