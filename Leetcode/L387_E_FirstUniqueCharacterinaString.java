package Leetcode;

public class L387_E_FirstUniqueCharacterinaString {

    /**
     * https://leetcode.com/problems/first-unique-character-in-a-string/
     */

    public static void main(String[] args) {
//        String test = "aabb";
//        String test = "leetcode";
        String test = "loveleetcode";

        System.out.println(firstUniqChar(test));
    }

    //6 ms、39.1 MB
    public static int firstUniqChar(String s) {
        int[] array = new int[26];
        int temp = -1;
        int length = s.length();

        for (int i = 0; i < length; i++) {
            int index = (int) s.charAt(i) - 97;
            if (array[index] > 0) {
                array[index] += s.length();
            } else {
                array[index] = i + s.length();
            }
        }
        for (int i = 0; i < array.length; i++) {
            int nowIndex = array[i] - length;
            if (array[i] > 0 && nowIndex < length) {
                temp = (temp == -1) ? nowIndex : Math.min(temp, nowIndex);
            }
        }
        return temp;
    }

    //別人寫的：5 ms、39.3 MB
    public static int firstUniqChar2(String s) {
        int[] array = new int[26];

        for (char c : s.toCharArray()) {
            array[c - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (array[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
