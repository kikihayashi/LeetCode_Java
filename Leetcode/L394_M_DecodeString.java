package Leetcode;

import java.util.Stack;

public class L394_M_DecodeString {

    /**
     * https://leetcode.com/problems/decode-string/
     */

    public static void main(String[] args) {
        String test = "2[abc]3[cd]ef";//abcabccdcdcdef
        String test2 = "3[a2[c]]";//accaccacc
        String test3 = "10[you]";

        System.out.println(decodeString(test3));
    }

    public static String decodeString(String s) {
        Stack<String> stack = new Stack();

        for (char c : s.toCharArray()) {
            if (c == ']') {
                StringBuilder sb = new StringBuilder();
                String letters = "";
                while (!"[".equals(stack.peek())) {
                    letters = stack.pop() + letters;
                }
                stack.pop();//移除"["

                String repeat = "";
                while (!stack.isEmpty() && Character.isDigit(stack.peek().charAt(0))) {
                    repeat = stack.pop() + repeat;
                }

                int number = Integer.valueOf(repeat);
                while (number-- > 0) {
                    sb.append(letters);
                }
                stack.push(sb.toString());
            } else {
                stack.push(String.valueOf(c));
            }
        }

        String ans = "";
        while (!stack.isEmpty()) {
            ans = stack.pop() + ans;
        }
        return ans;
    }

    public static String decodeString2(String s) {
        Stack<String> stack = new Stack();

        for (char c : s.toCharArray()) {
            if (c == ']') {
                StringBuilder sb = new StringBuilder();
                String letters = "";
                while (!"[".equals(stack.peek())) {
                    letters = stack.pop() + letters;
                }
                stack.pop();

                String repeat = "";
                while (!stack.isEmpty() && '0' <= stack.peek().charAt(0) && stack.peek().charAt(0) <= '9') {
                    repeat = stack.pop() + repeat;
                }

                int number = Integer.valueOf(repeat);
                while (number-- > 0) {
                    sb.append(letters);
                }
                stack.push(sb.toString());
            } else {
                stack.push(String.valueOf(c));
            }
        }

        String ans = "";
        while (!stack.isEmpty()) {
            ans = stack.pop() + ans;
        }
        return ans;
    }
}
