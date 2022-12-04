package Leetcode;

import java.util.*;

public class L424_M_LongestRepeatingCharacterReplacement {

    /**
     * https://leetcode.com/problems/longest-repeating-character-replacement/?envType=study-plan&id=level-1
     */


    public static void main(String[] args) {
//        String s = "ABAB";
//        int k = 2;
//        String s = "AABABBA";
//        int k = 1;

        String s = "AZBCDBBA";
        int k = 1;


        System.out.println(characterReplacement(s, k));
    }

    public static int characterReplacement(String s, int k) {
        int start = 0;
        //替換後最長長度
        int longestLength = 0;
        //出現最多次次數
        int maxFrequency = 0;
        int[] map = new int[26];

        for (int end = 0; end < s.length(); end++) {
            map[s.charAt(end) - 'A']++;
            maxFrequency = Math.max(maxFrequency, map[s.charAt(end) - 'A']);

            //如果需要替換的數量(總長度-出現最多次次數) <= k
            if ((end - start + 1) - maxFrequency <= k) {
                longestLength = Math.max(longestLength, end - start + 1);
            } else {
                map[s.charAt(start) - 'A']--;
                start++;
            }
        }
        return longestLength;
    }

    public static int characterReplacement2(String s, int k) {
        int longestNumber = 0;
        int number = 1;
        int temp = 0;
        int index = 1;
        int indexDiff = 0;
        char currentChar = s.charAt(0);
        while (index < s.length()) {
            if (currentChar == s.charAt(index)) {
                number++;
                index++;
            } else {
                if (indexDiff == 0) {
                    indexDiff = index;
                }
                if (temp < k) {
                    temp++;
                    number++;
                    index++;
                } else {
                    longestNumber = Math.max(longestNumber, number);
                    temp = 0;
                    number = 1;
                    currentChar = s.charAt(indexDiff);
                    index = indexDiff + 1;
                    indexDiff = 0;
                }
            }
        }
        if (temp < k) {
            number += (k - temp);
            if (number > s.length()) {
                number = s.length();
            }
        }
        longestNumber = Math.max(longestNumber, number);
        return longestNumber;
    }


}
