package Leetcode;

import java.util.Arrays;

public class L459_E_RepeatedSubstringPattern {

    public static void main(String[] args) {

//        String test = "abaababaab";
//        String test = "abaab";
//        String test = "ababababc";
//        String test = "ababcababc";
//        String test = "a";
//        String test = "ababa";
//        String test = "abababab";
        String test = "baatggggbaat";

        System.out.println(repeatedSubstringPattern(test));
    }

    //https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0459.%E9%87%8D%E5%A4%8D%E7%9A%84%E5%AD%90%E5%AD%97%E7%AC%A6%E4%B8%B2.md
    public static boolean repeatedSubstringPattern(String s) {
        int length = s.length();
        if (length == 1) {
            return false;
        }
        int[] next = getNext(new int[length], s);
        System.out.println(Arrays.toString(next));
        return next[length - 1] != 0 && length % (length - next[length - 1]) == 0;
    }

    //前綴表
    private static int[] getNext(int[] next, String s) {
        //初始化
        int j = 0;
        next[0] = 0;
        for (int i = 1; i < s.length(); i++) {
            //處理不同的情形
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = next[j - 1];
            }
            //處理相同的情形
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            //存入前綴表
            next[i] = j;
        }
        return next;
    }
}
