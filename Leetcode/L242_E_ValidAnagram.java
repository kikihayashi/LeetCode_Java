package Leetcode;

import java.util.*;

public class L242_E_ValidAnagram {

    /**
     * https://leetcode.com/problems/valid-anagram/
     */

    public static void main(String[] args) {
        String test1 = "anagram";
        String test2 = "nagaram";

        System.out.println(isAnagram(test1, test2));
    }

    //1 ms、38.9 MB
    public static boolean isAnagram(String s, String t) {
        int[] check = new int[128];
        for (char c : s.toCharArray()) {
            check[c]++;
        }
        for (char c : t.toCharArray()) {
            check[c]--;
        }
        for (int i : check) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }


    //別人寫的：1 ms、39.4 MB
    public static boolean isAnagram4(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] array = new int[128];

        for (char c : s.toCharArray()) {
            array[c]++;
        }
        for (char c : t.toCharArray()) {
            array[c]--;
        }
        for (int i : array) {
            if (i < 0) {
                return false;
            }
        }
        return true;
    }

    //24 ms、39 MB
    public static boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 1) + 1);
            } else {
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 1));
            }

            if (map.containsKey(t.charAt(i))) {
                map.put(t.charAt(i), map.getOrDefault(t.charAt(i), -1) - 1);
            } else {
                map.put(t.charAt(i), map.getOrDefault(t.charAt(i), -1));
            }
        }

        return "".equals(map.values().toString()
                .replace("[", "")
                .replace("]", "")
                .replace(",", "")
                .replace("0", "")
                .trim());
    }

    //13 ms、39.4 MB
    public static boolean isAnagram3(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }

        for (int i = 0; i < t.length(); i++) {
            if (map.containsKey(t.charAt(i))) {
                if (map.get(t.charAt(i)) == 0) {
                    return false;
                } else {
                    map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
                }

            } else {
                return false;
            }
        }
        return true;
    }
}
