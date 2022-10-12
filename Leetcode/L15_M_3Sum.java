package Leetcode;

import java.util.*;

public class L15_M_3Sum {

    /**
     * https://leetcode.com/problems/3sum/
     */

    public static void main(String[] args) {
//        int[] test = new int[]{-1, 0, 1, 2, -1, -4};
        int[] test = new int[]{-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4};

        List<List<Integer>> finalList = threeSum(test);

        for (List<Integer> list : finalList) {
            System.out.println(list);
        }
    }

    //17 ms、43.6 MB
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> finalList = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            int twoTarget = 0 - (nums[i]);
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                if (nums[left] + nums[right] < twoTarget) {
                    left++;
                } else if (nums[left] + nums[right] > twoTarget) {
                    right--;
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    finalList.add(list);

                    int leftValue = nums[left];
                    int rightValue = nums[right];

                    while (nums[left] == leftValue && left < nums.length - 1) {
                        left++;
                    }
                    while (nums[right] == rightValue && right > i + 1) {
                        right--;
                    }
                }
            }
        }
        return finalList;
    }


}
