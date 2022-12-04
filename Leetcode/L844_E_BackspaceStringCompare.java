package Leetcode;

import java.util.Stack;

public class L844_E_BackspaceStringCompare {

    /**
     * https://leetcode.com/problems/backspace-string-compare/
     */

    public static void main(String[] args) {
        String s = "ab##";
        String t = "c#d#";
//
//        String s = "a#c";
//        String t = "b";

        System.out.println(backspaceCompare(s, t));
    }

    public static boolean backspaceCompare(String s, String t) {
        Stack<Character> s_stack = new Stack<>();
        Stack<Character> t_stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '#') {
                if (!s_stack.isEmpty()) {
                    s_stack.pop();
                }
            } else {
                s_stack.push(c);
            }
        }

        for (char c : t.toCharArray()) {
            if (c == '#') {
                if (!t_stack.isEmpty()) {
                    t_stack.pop();
                }
            } else {
                t_stack.push(c);
            }
        }

        if (s_stack.size() == t_stack.size()) {
            while (!s_stack.isEmpty()) {
                if (s_stack.pop() != t_stack.pop()) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
