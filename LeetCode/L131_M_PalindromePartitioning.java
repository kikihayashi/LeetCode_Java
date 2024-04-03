package LeetCode;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/palindrome-partitioning/
 */

public class L131_M_PalindromePartitioning {

    private static List<List<String>> result = new LinkedList<>();

    public static void main(String[] args) {
        String palindrome = "abac";
        partition(palindrome);
        System.out.println(result);
    }

    public static List<List<String>> partition(String s) {
        result = new LinkedList<>();
        backtracking(0, s, new LinkedList<>());
        return result;
    }

    public static void backtracking(int startIndex, String palindrome, LinkedList<String> list) {
        if (startIndex == palindrome.length()) {
            result.add(new LinkedList<>(list));
            return;
        }

        for (int i = startIndex; i < palindrome.length(); i++) {
            String range = palindrome.substring(startIndex, i + 1);
            if (isPalindrome(range.toCharArray())) {
                list.add(range);
                backtracking(i + 1, palindrome, list);
                list.removeLast();
            }
        }
    }

    private static boolean isPalindrome(char[] ch) {
        int start = 0;
        int end = ch.length - 1;
        while (start < end) {
            if (ch[start] != ch[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
