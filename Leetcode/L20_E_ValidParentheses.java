package Leetcode;

import java.util.Stack;

public class L20_E_ValidParentheses {

    /**
     * https://leetcode.com/problems/valid-parentheses/
     */

    public static void main(String[] args) {
        String s= "{[]}";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        char[] charArray = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : charArray) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.size() == 0) {
                    return false;
                } else {
                    if (stack.peek() == reverse(c)) {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            }
        }
        return (stack.size()==0);
    }

    private static Character reverse(char c) {
        switch (c) {
            case ')':
                return '(';
            case ']':
                return '[';
            case '}':
                return '{';
        }
        throw new IllegalArgumentException();
    }
}
