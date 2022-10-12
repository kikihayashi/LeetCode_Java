package Leetcode;

public class L541_E_ReverseStringII {

    /**
     * https://leetcode.com/problems/reverse-string-ii/
     */

    public static void main(String[] args) {
        String test = "hyzqyljrnigxvdtneasepfahmtyhlohwxmkqcdfehybknvdmfrfvtbsovjbdhevlfxpdaovjgunjqlimjkfnqcqnajmebeddqsgl";
        int n = 39;

        String ans = "fdcqkmxwholhytmhafpesaentdvxginrjlyqzyhehybknvdmfrfvtbsovjbdhevlfxpdaovjgunjqllgsqddebemjanqcqnfkjmi";

//        String test = "abcdefg";
//        int n = 3;

//        String test = "abcdefg";
//        int n = 8;

//        String test = "abcd";
//        int n = 4;

        System.out.println("input ：" + test);
        System.out.println("result：" + reverseStr(test, n));
        System.out.println("ans   ：" + ans);
        System.out.println(ans.equals(reverseStr(test, n)));
    }

    //0 ms、39 MB
    public static String reverseStr(String s, int k) {
        int index = 0, p1, p2;
        char[] temp = s.toCharArray();
        while (true) {
            p1 = index * 2 * k;
            p2 = p1 + (k - 1);
            if (p1 < s.length() - 1) {
                if (p2 < s.length() - 1) {
                    temp = reverseCharArray(temp, p1, p2);
                    index++;
                } else {
                    temp = reverseCharArray(temp, p1, s.length() - 1);
                    break;
                }
            } else {
                break;
            }
        }
        return String.valueOf(temp);
    }

    public static char[] reverseCharArray(char[] s, int first, int last) {
        while (first < last) {
            char start = s[first];
            char end = s[last];
            s[first] = end;
            s[last] = start;
            first++;
            last--;
        }
        return s;
    }
}
