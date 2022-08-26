package LeetCode;

public class L557_E_ReverseWordsinaStringIII {

    /**
     * https://leetcode.com/problems/reverse-words-in-a-string-iii/
     */

    public static void main(String[] args) {

        String test = "Let's take LeetCode contest";
        String ans = "s'teL ekat edoCteeL tsetnoc";

        System.out.println(reverseWords(test));
        System.out.println(ans.equals(reverseWords(test)));
    }

    //3 ms、39.2 MB
    public static String reverseWords(String s) {
        String[] stringArray = s.split(" ");
        char[] temp = s.toCharArray();
        int index = 0;
        int p1 = 0;
        int p2 = stringArray[index].length() - 1;
        temp = reverseCharArray(temp, p1, p2);

        while (index < stringArray.length - 1) {
            index++;
            p1 = p2 + 2;
            p2 += (stringArray[index].length() + 1);
            temp = reverseCharArray(temp, p1, p2);
        }
        return String.valueOf(temp);
    }

    //3 ms、39.4 MB
    public static String reverseWords2(String s) {
        char[] temp = s.toCharArray();
        int p1 = 0;
        int p2 = 1;

        while (p2 < s.length()) {
            if (temp[p2] != ' ') {
                p2++;
            } else {
                temp = reverseCharArray(temp, p1, p2 - 1);
                p1 = p2 + 1;
                p2 += 2;
            }
        }
        temp = reverseCharArray(temp, p1, p2 - 1);
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
