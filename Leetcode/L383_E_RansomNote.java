package Leetcode;

public class L383_E_RansomNote {

    /**
     * https://leetcode.com/problems/ransom-note/
     */

    public static void main(String[] args) {
        String test1 = "aa";
        String test2 = "ab";

        System.out.println(canConstruct(test1, test2));

    }

    //1 ms、39.2 MB
    public static boolean canConstruct(String ransomNote, String magazine) {
        if (magazine.length() < ransomNote.length()) {
            return false;
        }
        int[] temp = new int[26];
        for (char c : ransomNote.toCharArray()) {
            temp[c - 'a']++;
        }
        for (char c : magazine.toCharArray()) {
            if (temp[c - 'a'] != 0) {
                temp[c - 'a']--;
            }
        }
        for (int i : temp) {
            if (i > 0) {
                return false;
            }
        }
        return true;
    }

}
