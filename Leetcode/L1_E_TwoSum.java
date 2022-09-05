package LeetCode;

import java.util.Arrays;
import java.util.HashMap;

public class L1_E_TwoSum {

    /**
     * https://leetcode.com/problems/two-sum/
     */

    public static void main(String[] args) {
        int[] nums = new int[]{1, 6142, 8192, 10239};
        int target = 18431;
        System.out.println(Arrays.toString(twoSum(nums, target)));

    }

    public static int[] twoSum(int[] nums, int target) {
        if (nums.length == 2) {
            return new int[]{0, 1};
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
            map.put(nums[i],i);
        }
        return new int[2];
    }

//    public static int[] twoSum(int[] nums, int target) {
//        if (nums.length == 2) {
//            return new int[]{0, 1};
//        }
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[i] + nums[j] == target) {
//                    return new int[]{i, j};
//                } else {
//
//                }
//            }
//        }
//        return new int[2];
//    }


}
