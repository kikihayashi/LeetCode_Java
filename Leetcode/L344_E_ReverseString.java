package LeetCode;

import java.util.Arrays;

public class L344_E_ReverseString {

    /**
     * https://leetcode.com/problems/reverse-string/
     */

    public static void main(String[] args) {
        char[] test = new char[]{'h', 'e', 'l', 'l', 'o'};
        reverseString(test);
//        iterativeMethod(test,0,2);

        System.out.println(Arrays.toString(test));
    }

    public static void reverseString(char[] s) {
        /**
         *  recursiveMethod
         */
//        recursiveMethod(s, 0, s.length - 1);

        /**
         *  iterativeMethod
         */
        iterativeMethod(s, 0, s.length - 1);
    }

    public static void iterativeMethod(char[] s, int first, int last) {
        while (first < last) {
            char start = s[first];
            char end = s[last];
            s[first] = end;
            s[last] = start;
            first++;
            last--;
        }
        return;
    }

    public static void recursiveMethod(char[] s, int first, int last) {
        if (first >= last) {
            return;
        }
        char start = s[first];
        char end = s[last];
        s[first] = end;
        s[last] = start;
        recursiveMethod(s, ++first, --last);
    }
}
