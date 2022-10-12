package Leetcode;

import java.util.Stack;

public class L345_E_ReverseVowelsofaString {

    /**
     * https://leetcode.com/problems/reverse-vowels-of-a-string/
     */

    public static void main(String[] args) {
        String test = "leetcode";
//        String test = "hello";

        System.out.println(reverseVowels(test));
    }

    //5 ms、41.9 MB
    public static String reverseVowels(String s) {
        int left = 0;
        int right = s.length() - 1;
        char[] temp = s.toCharArray();

        while (left < right) {
            if (isVowels(temp[left]) && isVowels(temp[right])) {
                char tempVowel = temp[left];
                temp[left] = temp[right];
                temp[right] = tempVowel;
                left++;
                right--;
            } else {
                if (!isVowels(temp[left])) {
                    left++;
                }
                if (!isVowels(temp[right])) {
                    right--;
                }
            }
        }
        return String.valueOf(temp);
    }

    //20 ms、45.7 MB
    public static String reverseVowels2(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (isVowels(c)) {
                stack.add(c);
            }
        }
        for (char c : s.toCharArray()) {
            if (isVowels(c)) {
                sb.append(stack.pop());
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    private static boolean isVowels(char v) {
        return (v == 'a') || (v == 'e') || (v == 'i') || (v == 'o') || (v == 'u') ||
                (v == 'A') || (v == 'E') || (v == 'I') || (v == 'O') || (v == 'U');
    }

}
