package Leetcode;

import java.util.Stack;

public class L1047_E_RemoveAllAdjacentDuplicatesInString {

    /**
     * https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
     */

    public static void main(String[] args) {
        String s = "azxxzy";
        System.out.println(removeDuplicates(s));
    }


    //https://github.com/youngyangyang04/leetcode-master/blob/master/problems/1047.%E5%88%A0%E9%99%A4%E5%AD%97%E7%AC%A6%E4%B8%B2%E4%B8%AD%E7%9A%84%E6%89%80%E6%9C%89%E7%9B%B8%E9%82%BB%E9%87%8D%E5%A4%8D%E9%A1%B9.md
    //別人寫的：9 ms、45.7 MB
    public static String removeDuplicates(String s) {
        int length = s.length();
        char[] origin = s.toCharArray();
        int fast = 0;
        int slow = 0;

        while (fast < length) {
            origin[slow] = origin[fast];
            if (slow > 0 && origin[slow] == origin[slow - 1]) {
                slow--;
            } else {
                slow++;
            }
            fast++;
        }
        return new String(origin, 0, slow);
    }

    //25 ms、46.4 MB
    public static String removeDuplicates3(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (sb.length() == 0) {
                sb.append(c);
            } else {
                if (sb.charAt(sb.length() - 1) == c) {
                    sb.deleteCharAt(sb.length() - 1);
                } else {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }

    //138 ms、41.2 MB
    public static String removeDuplicates2(String s) {
        Stack<Character> stack = new Stack<>();
        String temp = "";

        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.add(c);
            } else {
                if (stack.peek() == c) {
                    stack.pop();
                } else {
                    stack.add(c);
                }
            }
        }

        while (!stack.isEmpty()) {
            temp = stack.pop() + temp;
        }
        return temp;
    }


}
