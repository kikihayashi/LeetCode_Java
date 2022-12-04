package Leetcode;

import java.util.HashMap;
import java.util.Map;

public class L205_E_IsomorphicStrings {

    /**
     * https://leetcode.com/problems/isomorphic-strings/
     */

    public static void main(String[] args) {

        String s = "egg";
        String t = "add";
//        String s = "title";
//        String t = "paper";
//        String s = "bar";
//        String t = "foo";
        System.out.println(isIsomorphic(s, t));
    }

    private static Map<Character, Character> map;

    public static boolean isIsomorphic(String s, String t) {
        map = new HashMap<>();
        char[] charArrayS = s.toCharArray();
        char[] charArrayT = t.toCharArray();

        for (int i = 0; i < charArrayS.length; i++) {
            if (map.containsKey(charArrayS[i])) {
                if (map.get(charArrayS[i]) != charArrayT[i]) {
                    return false;
                }
            } else {
                if (map.containsValue(charArrayT[i])) {
                    return false;
                }
                map.put(charArrayS[i], charArrayT[i]);
            }
        }
        return true;
    }
}
