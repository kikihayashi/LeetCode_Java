package Leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */

public class L17_M_LetterCombinationsOfAPhoneNumber {

    private static List<String> result;

    private static Map<Character, char[]> map = Map.of(
            '2', new char[]{'a', 'b', 'c'},
            '3', new char[]{'d', 'e', 'f'},
            '4', new char[]{'g', 'h', 'i'},
            '5', new char[]{'j', 'k', 'l'},
            '6', new char[]{'m', 'n', 'o'},
            '7', new char[]{'p', 'q', 'r', 's'},
            '8', new char[]{'t', 'u', 'v'},
            '9', new char[]{'w', 'x', 'y', 'z'}
    );

    public static void main(String[] args) {
        String digits = "23";
        letterCombinations(digits);
        System.out.println(result);
    }

    public static List<String> letterCombinations(String digits) {
        result = new LinkedList<>();
        if ("".equals(digits)) {
            return result;
        }
        backtracking(0, digits.toCharArray(), new StringBuilder());
        return result;
    }

    public static void backtracking(int numberIndex, char[] numbers, StringBuilder sb) {
        if (numberIndex == numbers.length) {
            result.add(sb.toString());
            return;
        }
        char number = numbers[numberIndex];
        for (char letter : map.get(number)) {
            sb.append(letter);
            backtracking(numberIndex + 1, numbers, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
