package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L18_M_4Sum {

    /**
     * https://leetcode.com/problems/4sum/
     */

    public static void main(String[] args) {
//        int[] test = new int[]{1, 0, -1, 0, -2, 2};
//        int[] test = new int[]{-2, -1, -1, 1, 1, 2, 2};
//        int[] test = new int[]{2, 2, 2, 2, 2};
        int[] test = new int[]{-2, -1, -1, 0, 1, 2, 2, 2};
//        int[] test = new int[]{-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4};
        int n = 0;

        List<List<Integer>> finalList = fourSum(test, n);

        for (List<Integer> list : finalList) {
            System.out.println(list);
        }
    }

    //12 ms、39.2 MB
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> finalList = new ArrayList<>();
        Arrays.sort(nums);
        for (int k = 0; k < nums.length - 3; k++) {
            if (k > 0 && nums[k - 1] == nums[k]) {
                continue;
            }
            int threeTarget = target - (nums[k]);

            for (int i = k + 1; i < nums.length - 2; i++) {
                if (i > k + 1 && nums[i - 1] == nums[i]) {
                    continue;
                }
                int twoTarget = threeTarget - (nums[i]);
                int left = i + 1;
                int right = nums.length - 1;

                while (left < right) {
                    if (nums[left] + nums[right] < twoTarget) {
                        left++;
                    } else if (nums[left] + nums[right] > twoTarget) {
                        right--;
                    } else {

                        List<Integer> list = Arrays.asList(nums[k], nums[i], nums[left], nums[right]);
                        System.out.println(k + "" + i + "" + left + "" + right);
//                        List<Integer> list = new ArrayList<>();
//                        list.add(nums[k]);
//                        list.add(nums[i]);
//                        list.add(nums[left]);
//                        list.add(nums[right]);
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
        }
        return finalList;
    }


}
