package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/?envType=study-plan&id=level-1
 */

public class L438_M_FindAllAnagramsinaString {


    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
//        String s = "abab";
//        String p = "ab";
        System.out.println(findAnagrams(s, p));
    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s.length() < p.length()) {
            return list;
        }
        int[] sHashTable = new int[26];
        int[] pHashTable = new int[26];
        int start = 0;
        int end = p.length() - 1;

        for (int i = start; i <= end; i++) {
            sHashTable[s.charAt(i) - 97]++;
        }

        for (char c : p.toCharArray()) {
            pHashTable[c - 97]++;
        }

        while (end < s.length()) {
            if (checkIfAnagramsEqual(sHashTable, pHashTable)) {
                list.add(start);
            }
            sHashTable[s.charAt(start) - 97]--;
            start++;
            end++;
            if (end < s.length()) {
                sHashTable[s.charAt(end) - 97]++;
            }
        }
        return list;
    }

    private static boolean checkIfAnagramsEqual(int[] sT, int[] pT) {
        for (int i = 0; i < 26; i++) {
            if (pT[i] != sT[i]) {
                return false;
            }
        }
        return true;
    }
}
