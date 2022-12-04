package Leetcode;

import java.util.Arrays;

public class L1480_E_RunningSumof1dArray {

    /**
     * https://leetcode.com/problems/running-sum-of-1d-array/?envType=study-plan&id=level-1
     */

    public static void main(String[] args) {

        int[] nums = new int[]{3, 1, 2, 10, 1};
        System.out.println(Arrays.toString(runningSum(nums)));

    }

    public static int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }
}
