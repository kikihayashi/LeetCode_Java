package LeetCode;

public class L268_E_MissingNumber {

    /**
     * https://leetcode.com/problems/missing-number/
     */

    public static void main(String[] args) {

        int[] test = new int[]{1, 2};

        System.out.println(missingNumber(test));

    }


    //自己寫的0 ms、39.7 MB
    public static int missingNumber(int[] nums) {
        int value = (1 + nums.length) * nums.length / 2;
        for (int i = 0; i < nums.length; i++) {
            value -= nums[i];
        }
        return value;
    }

    //別人寫的1 ms、48.2 MB
    public static int missingNumber2(int[] nums) {
        int value = 0;
        for (int i = 0; i < nums.length; i++) {
            value ^= (i ^ nums[i]);
        }
        return value ^ nums.length;
    }


}
