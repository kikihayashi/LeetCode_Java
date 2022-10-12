package Leetcode;

import java.util.Arrays;

public class L977_E_SquaresofaSortedArray {

    /**
     * https://leetcode.com/problems/squares-of-a-sorted-array/
     */

    public static void main(String[] args) {
//        int[] test = new int[]{-1, 0, 3, 5, 9, 12};
//        int[] test = new int[]{-5, -3, -2, -1};
//        int[] test = new int[]{3, 5, 9, 12};
//        int[] test = new int[]{-4, -1, 0, 3, 10};
        int[] test = new int[]{-10000, -9999, -7, -5, 0, 0, 10000};

        System.out.println(Arrays.toString(sortedSquares(test)));
    }

    public static int[] sortedSquares(int[] nums) {
        int[] temp = new int[nums.length];
        int start = 0;
        int end = nums.length - 1;
        int index = nums.length - 1;

        while (start <= end) {
            int tempStart = nums[start] * nums[start];
            int tempEnd = nums[end] * nums[end];

            if (tempStart > tempEnd) {
                temp[index] = tempStart;
                start++;
            } else {
                temp[index] = tempEnd;
                end--;
            }
            index--;
        }
        return temp;
    }
}
