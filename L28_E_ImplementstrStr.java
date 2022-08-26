package LeetCode;

import java.lang.reflect.Array;
import java.util.Arrays;

public class L28_E_ImplementstrStr {

    /**
     * https://leetcode.com/problems/implement-strstr/
     * https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0028.%E5%AE%9E%E7%8E%B0strStr.md
     */

    public static void main(String[] args) {

//        String haystack = "helcallo";
//        String needle = "ll";
//        String haystack = "mississippi";
//        String needle = "issipi";
//        String haystack = "mississippi";
//        String needle = "issip";
        String haystack = "aabaabaafc";
//        String needle = "baab";
        String needle = "aabaaf";
//        String haystack = "a";
//        String needle = "a";

        int[] next = new int[needle.length()];



        System.out.println(strStr(haystack, needle));
    }

    /**
     * KMP演算法--------------------------------------------------------------------------------------------
     * */
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

    //33 ms、40.3 MB、 87.01%
    public static int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        int[] next = getNext(new int[needle.length()], needle);

        System.out.println(Arrays.toString(next));

        int j = 0;

        for (int i = 1; i <= haystack.length(); i++) {
            while (j > 0 && haystack.charAt(i - 1) != needle.charAt(j)) {
                j = next[j - 1];
            }
            if (haystack.charAt(i - 1) == needle.charAt(j)) {
                j++;
            }
            if (j > needle.length() - 1) {
                return i - j;
            }
        }
        return -1;
    }

    /**
     * KMP演算法--------------------------------------------------------------------------------------------
     * */

    //627 ms、174.3 MB、 43.85%
    public static int strStr1(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (needle.equals(haystack.substring(i, i + needle.length()))) {
                return i;
            }
        }
        return -1;
    }

    //859 ms、40.2 MB、34.72%
    public static int strStr2(String haystack, String needle) {
        int k = 1;
        if (needle.equals("")) {
            return 0;
        }
        char[] hArray = haystack.toCharArray();
        char[] nArray = needle.toCharArray();

        for (int i = 0; i <= hArray.length - nArray.length; i++) {
            System.out.println("------");
            System.out.println("**");
            if (hArray[i] == nArray[0]) {
                int j = 1;
                while (true) {
                    System.out.println(k++);
                    if (j == nArray.length) {
                        return i;
                    }
                    if (hArray[i + j] == nArray[j]) {
                        j++;
                    } else {
                        break;
                    }
                }
            }
        }
        return -1;
    }
}
