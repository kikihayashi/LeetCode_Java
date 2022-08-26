package LeetCode;

import java.util.Arrays;

public class L69_E_Sqrtx {

    /**
     * https://leetcode.com/problems/sqrtx/
     */

    public static void main(String[] args) {
        int test = 8;

        System.out.println(mySqrt(test));
    }

    //用牛頓法：1 ms、35.7 MB
    public static int mySqrt2(int x) {
        double temp = 1;
        while (true) {
            double value = temp / 2 + (double) x / temp / 2;
            if ((int) value - (int) temp == 0) {
                return (int) value;
            } else {
                temp = value;
            }
        }
    }

    //別人寫的Binary Search 1 ms、35.6 MB
    public static int mySqrt(int x) {
        long start = 1;
        long end = x;

        while (start <= end) {
            long mid = start + (end - start) / 2;

            if (mid * mid > x) {
                end = mid - 1;
            } else if (mid * mid < x) {
                start = mid + 1;
            } else {
                return (int) mid;
            }
        }
        return (int) end;
    }
}
