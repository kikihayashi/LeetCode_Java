package LeetCode;

public class L136_E_SingleNumber {

    /**
     * https://leetcode.com/problems/single-number/
     */

    public static void main(String[] args) {

        int[] test = new int[]{1, 0, 1, 0, 77};

        System.out.println(singleNumber(test));
    }

    public static int singleNumber(int[] nums) {
        int number = nums[0];
        for (int i = 1; i < nums.length; i++) {
            number ^= nums[i];
        }
        return number;
    }
}
