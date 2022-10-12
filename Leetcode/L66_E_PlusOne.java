package Leetcode;

import java.util.Arrays;

public class L66_E_PlusOne {

    /**
     * https://leetcode.com/problems/plus-one/
     */


    public static void main(String[] args) {
        int[] test = new int[]{9};

        System.out.println(Arrays.toString(plusOne(test)));
    }

    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i]++;
                return digits;
            } else {
                digits[i] = 0;
            }
        }
        if (digits[0] == 0) {
            int[] temp = new int[digits.length + 1];
            temp[0] = 1;
            return temp;
        } else {
            return digits;
        }
    }

}
