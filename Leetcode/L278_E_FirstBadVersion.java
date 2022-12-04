package Leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class L278_E_FirstBadVersion {

    /**
     * https://leetcode.com/problems/first-bad-version/
     */

    public static void main(String[] args) {


        System.out.println(firstBadVersion(100));
    }

    public static int firstBadVersion(int n) {
        int left = 1;
        int right = n;

        while (right - left >= 1) {
            int middle = (left / 2 + right / 2);
            if (isBadVersion(middle)) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }
        return right;
    }

    public static boolean isBadVersion(int version) {
        return version >= 3;
    }
}
