package Leetcode;

public class L680_E_ValidPalindromeII {

    /**
     * https://leetcode.com/problems/valid-palindrome-ii/
     */

    public static void main(String[] args) {
//        String test = "ebcbbececabbacecbbcbe";//true
        String test = "eeccccbebaeeabebccceea";//false
//        String test = "abac";//true
//        String test = "cbbcc";//true
//        String test = "aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga";//true
//        String test = "aguokepatgbnvfqmgml cupuu fxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxf uupucu lmgmqfvnbgtapekouga";
//        String test = "abc";//false

        System.out.println(validPalindrome(test));
    }

    //4 ms、39.4 MB
    public static boolean validPalindrome(String s) {
        return recursiveMethod(s, true);
    }

    private static boolean recursiveMethod(String s, boolean chance) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else {
                if (chance) {
                    return recursiveMethod(s.substring(start, end), false) ||
                            recursiveMethod(s.substring(start + 1, end + 1), false);
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
