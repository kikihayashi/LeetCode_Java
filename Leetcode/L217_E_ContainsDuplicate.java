package Leetcode;

import java.util.Arrays;
import java.util.HashSet;

public class L217_E_ContainsDuplicate {

    /**
     * https://leetcode.com/problems/contains-duplicate/
     */

    public static void main(String[] args) {
        int[] test = new int[]{1, 2, 3, 9};
        System.out.println(containsDuplicate(test));
    }

    //自己寫的：5 ms、43.1 MB
    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (Integer i : nums) {
            if (set.contains(i)) {
                return true;
            }
            set.add(i);
        }
        return false;
    }

    //別人寫的：3 ms、42.3 MB
    public static boolean containsDuplicate2(int[] nums) {
        Arrays.sort(nums);
        int slow = 0;
        int fast = 1;

        while (fast <= nums.length - 1) {
            if (nums[slow] == nums[fast]) {
                return true;
            }
            slow++;
            fast++;
        }
        return false;
    }
}
