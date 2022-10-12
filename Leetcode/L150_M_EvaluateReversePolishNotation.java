package Leetcode;

import java.util.Stack;

public class L150_M_EvaluateReversePolishNotation {

    /**
     * https://leetcode.com/problems/evaluate-reverse-polish-notation/
     */

    public static void main(String[] args) {
        String[] test = new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(evalRPN(test));
    }

    //13 ms、42.1 MB
    public static int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();

        for (String s : tokens) {
            if (isSymbol(s)) {
                int n_End = Integer.parseInt(stack.pop());
                int n_Start = Integer.parseInt(stack.pop());
                stack.add(calculate(n_Start, n_End, s));
            } else {
                stack.add(s);
            }
        }
        return Integer.parseInt(stack.pop());
    }

    private static String calculate(int n_start, int n_end, String s) {
        int res = 0;
        switch (s) {
            case "+":
                res = n_start + n_end;
                break;
            case "-":
                res = n_start - n_end;
                break;
            case "*":
                res = n_start * n_end;
                break;
            case "/":
                res = n_start / n_end;
                break;
        }
        return String.valueOf(res);
    }

    private static boolean isSymbol(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }
}
