package Leetcode;

public class L14_E_LongestCommonPrefix {

    /**
     * https://leetcode.com/problems/longest-common-prefix/
     */


    public static void main(String[] args) {
        String[] test = new String[]{"flower", "flow", "flight"};
//        String[] test = new String[]{"cir", "car"};
//        String[] test = new String[]{"dog", "racecar", "car"};


        System.out.println(longestCommonPrefix(test));
    }

    public static String longestCommonPrefix(String[] strs) {
        StringBuilder prefix = new StringBuilder();
        char[] first = strs[0].toCharArray();
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() < first.length) {
                first = strs[i].toCharArray();
            }
        }

        for (int i = 0; i < first.length; i++) {
            for (String str : strs) {
                if (first[i] != str.toCharArray()[i]) {
                    return prefix.toString();
                }
            }
            prefix.append(first[i]);
        }
        return prefix.toString();
    }


    public String longestCommonPrefix2(String[] strs) {

        StringBuilder prefix = new StringBuilder();
        char[] first = strs[0].toCharArray();
        for (int i = 1; i < strs.length; i++) {
            if (strs[i].length() < first.length) {
                first = strs[i].toCharArray();
            }
        }

        for (int i = 0; i < first.length; i++) {
            int temp = 0;
            for (String str : strs) {
                if (str.length() > i) {
                    if (first[i] == str.toCharArray()[i]) {
                        temp++;
                    }
                } else {
                    return prefix.toString();
                }
            }
            if (temp == strs.length) {
                prefix.append(first[i]);
            } else {
                return prefix.toString();
            }
        }
        return prefix.toString();

    }


}
