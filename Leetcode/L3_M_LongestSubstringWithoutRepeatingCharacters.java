package Leetcode;

public class L3_M_LongestSubstringWithoutRepeatingCharacters {

    /**
     * https://leetcode.com/problems/longest-substring-without-repeating-characters/
     */

    public static void main(String[] args) {

        String s = "bbbbb";

        System.out.println(lengthOfLongestSubstring(s));


    }

    public static int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int length = 0;
        int[] map = new int[256];

        while (right < s.length()) {
            char c = s.charAt(right);
            if (map[c] > 0) {
                map[s.charAt(left)]--;
                left++;
            } else {
                map[c]++;
                right++;
            }
            length = Math.max(length, right - left);
        }
        return length;
    }
}
