package LeetCode;

import java.util.Arrays;

public class L167_E_TwoSumIIInputArrayIsSorted {

    /**
     * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
     */

    public static void main(String[] args) {
        int[] test = new int[]{2, 3, 4};
        int n = 6;
//        int[] test = new int[]{2, 7, 11, 15};
//        int n = 9;

        System.out.println(Arrays.toString(twoSum(test, n)));
    }

    public static int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            if (numbers[left] + numbers[right] < target) {
                left++;
            } else if (numbers[left] + numbers[right] > target) {
                right--;
            } else {
                break;
            }
        }
        return new int[]{left + 1, right + 1};
    }


}
