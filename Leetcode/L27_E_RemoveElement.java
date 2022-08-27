package LeetCode;

import java.util.Arrays;

public class L27_E_RemoveElement {

    /**
     * https://leetcode.com/problems/remove-element/
     */

    public static void main(String[] args) {
//        int[] test = new int[]{3, 2, 2, 3};
//        int n = 3;
        int[] test = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        int n = 2;

        System.out.println(removeElement(test, n));
    }

    public static int removeElement(int[] nums, int val) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            if (nums[right] == val) {
                right--;
                continue;
            }
            if (nums[left] != val) {
                left++;
            } else {
                nums[left++] = nums[right--];
            }
        }
        System.out.println(Arrays.toString(Arrays.copyOfRange(nums, 0, right + 1)));
        return right + 1;
    }

    public int removeElement2(int[] nums, int val) {
        int start = 0;
        int end = nums.length - 1;
        int expectedNums = nums.length;

        while (start <= end) {
            int startValue = nums[start];
            int endValue = nums[end];

            if (endValue == val) {
                end--;
                expectedNums--;
                continue;
            }
            if (startValue != val) {
                start++;
            } else {
                nums[start] = endValue;
                start++;
                end--;
                expectedNums--;
            }
        }
        return expectedNums;
    }
}
