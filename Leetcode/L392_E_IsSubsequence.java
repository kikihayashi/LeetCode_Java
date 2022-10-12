package Leetcode;

public class L392_E_IsSubsequence {

    /**
     * https://leetcode.com/problems/is-subsequence/
     */

    public static void main(String[] args) {
//        String test1 = "abc";
//        String test2 = "ahbgdc";

//        String test1 = "";
//        String test2 = "ahbgdc";

//        String test1 = "b";
//        String test2 = "c";

//        String test1 = "acb";
//        String test2 = "ahbgdc";

        String test1 = "axc";
        String test2 = "ahbgdc";

        System.out.println(isSubsequence(test1, test2));
    }

    //1 ms、38.7 MB
    public static boolean isSubsequence(String s, String t) {
        if (s.equals("")) {
            return true;
        }
        int ps = 0;
        int pt = 0;

        while (pt < t.length()) {
            if (s.charAt(ps) == t.charAt(pt)) {
                ps++;
            }
            pt++;
            if (ps == s.length()) {
                return true;
            }
        }
        return false;
    }


    //別人寫的：1 ms、38.4 MB
    public boolean isSubsequence2(String s, String t) {
        int i = 0;
        for (char ch : t.toCharArray()) {
            if (i < s.length() && ch == s.charAt(i)) {
                i++;
            }
        }
        if (i == s.length()) {
            return true;
        }
        return false;
    }
}
