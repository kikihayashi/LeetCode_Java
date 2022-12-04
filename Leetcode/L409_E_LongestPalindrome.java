package Leetcode;

public class L409_E_LongestPalindrome {

    /**
     * https://leetcode.com/problems/longest-palindrome/
     */

    public static void main(String[] args) {

//        String test = "abccPccddWw";
        String test = "ccc";
//        System.out.println((int) 'a');//97
//        System.out.println((int) 'A');//65
//        System.out.println((int) 'z');//122
//        System.out.println((int) 'Z');//90
        System.out.println(longestPalindrome(test));
    }

    public static int longestPalindrome(String s) {
        int[] temp = new int[128];
        int result = 0;

        for (char c : s.toCharArray()) {
            temp[c]++;
        }
        for (int i = 0; i < temp.length; i++) {
            int number = (temp[i] / 2) * 2;
            result += number;
            temp[i] -= number;
        }
        for (int number : temp) {
            if (number == 1) {
                return result + 1;
            }
        }
        return result;
    }
}
