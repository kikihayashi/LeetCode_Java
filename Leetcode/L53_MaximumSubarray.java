package Leetcode;

public class L53_MaximumSubarray {

    /**
     * https://leetcode.com/problems/maximum-subarray/
     */

    public static void main(String[] args) {
        int[] test = new int[]{5, 4, -1, 7, 8};
        System.out.println(maxSubArray(test));
    }

    public static int maxSubArray(int[] nums) {
        int max = nums[0];
        int subArray = max;
        for (int i = 1; i < nums.length; i++) {
            int nextArray = subArray + nums[i];
            if (nextArray > nums[i]) {
                subArray = nextArray;
            } else {
                subArray = nums[i];
            }

            if (max < subArray) {
                max = subArray;
            }
        }
        return max;
    }

//    public static int maxSubArray(int[] nums) {
//        int max = nums[0];
//        for (int i = 0; i < nums.length; i++) {
//            if (max < nums[i]) {
//                max = nums[i];
//            }
//            int temp = nums[i];
//            for (int j = i + 1; j < nums.length; j++) {
//                temp += nums[j];
//                if (max < temp) {
//                    max = temp;
//                }
//            }
//        }
//        return max;
//    }
}
