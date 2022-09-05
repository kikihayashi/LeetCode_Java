package LeetCode;

public class L209_M_MinimumSizeSubarraySum {

    /**
     * https://leetcode.com/problems/minimum-size-subarray-sum/
     */

    public static void main(String[] args) {
//        int[] test = new int[]{2};
//        int[] test = new int[]{2, 3, 1, 2, 4, 3};
//        int[] test = new int[]{5, 1, 3, 5, 10, 7, 4, 9, 2, 8};
//        int[] test = new int[]{1, 1, 1, 1};
        int[] test = new int[]{1, 2, 3, 4, 5};

//        int n = 12;
//        int n = 7;
//        int n = 15;
        int n = 11;

        System.out.println(minSubArrayLen(n, test));
    }

    //1 ms、38.9 MB
    public static int minSubArrayLen(int target, int[] nums) {
        int slow = 0;
        int fast = 1;
        int sum = nums[slow];
        int minNumber = 0;

        while (slow < nums.length) {
            if (target > sum) {
                if (fast < nums.length) {
                    sum += nums[fast];
                    fast++;
                } else {
                    return minNumber;
                }
            } else {
                if (minNumber == 0) {
                    minNumber = fast - slow;
                } else {
                    minNumber = Math.min(fast - slow, minNumber);
                }
                if (target == sum && fast < nums.length) {
                    sum += nums[fast];
                    fast++;
                }
                sum -= nums[slow];
                slow++;
            }
        }
        return minNumber;
    }

    //2 ms、38.6 MB
    public static int minSubArrayLen2(int target, int[] nums) {
        if (nums.length == 1) {
            return (nums[0] >= target) ? 1 : 0;
        }
        if (nums[0] >= target) {
            return 1;
        }
        int slow = 0;
        int fast = 1;
        int sum = nums[slow] + nums[fast];
        int minNumber = 0;

        while (fast < nums.length) {
            if (target > sum) {
                fast++;
                if (fast <= nums.length - 1) {
                    sum += nums[fast];
                }
            } else {
                System.out.println("temp:" + sum);
                System.out.println("slow:" + slow);
                System.out.println("fast:" + fast);
                System.out.println(fast - slow);
                System.out.println("----------");
                if (minNumber == 0) {
                    minNumber = fast - slow + 1;
                } else {
                    minNumber = Math.min(fast - slow + 1, minNumber);
                }
                if (fast < nums.length - 1 && target == sum) {
                    fast++;
                    sum += nums[fast];
                }
                sum -= nums[slow];
                slow++;
            }
        }
        return minNumber;
    }
}
