package Leetcode;

import java.util.Arrays;

public class L151_M_ReverseWordsinaString {

    /**
     * https://leetcode.com/problems/reverse-words-in-a-string/
     */

    public static void main(String[] args) {
        String test = "the sky is     blue";
//        String test = " the sky is     blue ";
//        String test = "  the sky is     blue  ";
//        String test = "  a good   example  ";
//        String test = "a good   example";
//        String test = " a good   example ";
//        String test = " a good   example a ";
//        String test = " a good   example a";
//        String test = "a good   example a ";
//        String test = "a good   example a";
//        String test = "a";
//        String test = "a c";
//        String test = "adsdsd    ";

        System.out.println(Arrays.toString(test.toCharArray()));
        System.out.println(reverseWords(test));
    }

    //4 ms、39.9 MB
    public static String reverseWords(String s) {
        if (s.length() == 1) {
            return s;
        }
        char[] temp = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int left = s.length() - 1;
        int right;

        while (left > 0) {
            while (left >= 0 && temp[left] == ' ') {
                left--;
            }
            right = left;
            while (left >= 0 && temp[left] != ' ') {
                left--;
            }
            System.out.println(left);
            System.out.println(right);
            System.out.println("----");
            if (left < 0 && right < 0) {
                break;
            } else {
                sb.append(s, left + 1, right + 1);
                sb.append(" ");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    //4 ms、39.2 MB(盡量不要用Library)
    public static String reverseWords2(String s) {
        String[] temp = s.split(" ");
        System.out.println(Arrays.toString(temp));

        StringBuilder sb = new StringBuilder();

        for (int i = temp.length - 1; i >= 0; i--) {
            if (!temp[i].equals("")) {
                sb.append(temp[i]);
                sb.append(" ");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }


}
