package Leetcode;

import java.util.HashMap;

public class L169_E_MajorityElement {

    /**
     * https://leetcode.com/problems/majority-element/
     */

    public static void main(String[] args) {

        int[] test = new int[]{2, 2, 1, 1, 1, 2, 2};

        System.out.println(majorityElement(test));

    }

    public static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
                if (map.get(nums[i]) > nums.length / 2) {
                    return nums[i];
                }
            } else {
                map.put(nums[i], 1);
            }
        }
        return nums[0];
    }

    //別人寫的
    public static int majorityElement2(int[] nums) {
        int countBox = 0;
        int person = 0;

        for (int num : nums) {

            if (countBox == 0) { // countBox is Empty
                person = num; // First Person in the Queue will be added to the Box
            }
            if (num == person) {// If the same person comes again
                countBox++;
            } else {
                countBox--; // If different person comes
            }
        }
        return person; // Last Person who remains in the box
    }
}
