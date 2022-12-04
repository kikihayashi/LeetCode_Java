package Leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;

public class L724_E_FindPivotIndex {

    /**
     * https://leetcode.com/problems/find-pivot-index/?envType=study-plan&id=level-1
     */

    public static void main(String[] args) {

//        int[] nums = new int[]{1, 7, 3, 6, 5, 6};
//        int[] nums = new int[]{1, 2, 3};
//        int[] nums = new int[]{1, -2, 2};
        int[] nums = new int[]{2, 1, -1};
        System.out.println(pivotIndex(nums));
    }

    public static int pivotIndex(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        int sum = nums[nums.length - 1];
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            if (temp == sum - nums[i]) {
                return i;
            }
            temp = nums[i];
        }
        return -1;
    }
}
