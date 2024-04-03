package LeetCode;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class L14_E_LongestCommonPrefix {

    /**
     * https://leetcode.com/problems/longest-common-prefix/
     */


    public static void main(String[] args) {
        String[] test = new String[]{"flower", "flow", "flight"};
//        String[] test = new String[]{"cir", "car"};
//        String[] test = new String[]{"dog", "racecar", "car"};
//        String[] test = new String[]{"a"};

        System.out.println(longestCommonPrefix(test));
    }

    public static String longestCommonPrefix(String[] strs) {
        int index = 0;
        String shortestString = strs[index];

        for (int i = 1; i < strs.length; i++) {
            if (strs[i].length() < shortestString.length()) {
                shortestString = strs[i];
                index = i;
            }
        }

        String answer = shortestString;

        for (int i = 0; i < strs.length; i++) {
            StringBuilder temp = new StringBuilder();
            if (i == index) {
                continue;
            }

            String nowString = strs[i];

            for (int j = 0; j < shortestString.length(); j++) {
                if (shortestString.toCharArray()[j] == nowString.toCharArray()[j]) {
                    temp.append(shortestString.toCharArray()[j]);
                } else {
                    break;
                }
            }

            if (temp.length() < answer.length()) {
                answer = temp.toString();
            }
        }
        return answer;
    }


    public static String longestCommonPrefix1(String[] strs) {
        StringBuilder prefix = new StringBuilder();
        char[] first = strs[0].toCharArray();
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() < first.length) {
                first = strs[i].toCharArray();
            }
        }

        for (int i = 0; i < first.length; i++) {
            for (String str : strs) {
                if (first[i] != str.toCharArray()[i]) {
                    return prefix.toString();
                }
            }
            prefix.append(first[i]);
        }
        return prefix.toString();
    }


    public String longestCommonPrefix2(String[] strs) {

        StringBuilder prefix = new StringBuilder();
        char[] first = strs[0].toCharArray();
        for (int i = 1; i < strs.length; i++) {
            if (strs[i].length() < first.length) {
                first = strs[i].toCharArray();
            }
        }

        for (int i = 0; i < first.length; i++) {
            int temp = 0;
            for (String str : strs) {
                if (str.length() > i) {
                    if (first[i] == str.toCharArray()[i]) {
                        temp++;
                    }
                } else {
                    return prefix.toString();
                }
            }
            if (temp == strs.length) {
                prefix.append(first[i]);
            } else {
                return prefix.toString();
            }
        }
        return prefix.toString();

    }


}
