package Leetcode;

public class L125_E_ValidPalindrome {

    /**
     * https://leetcode.com/problems/valid-parentheses/
     */

    public static void main(String[] args) {
        String test = "A man, a plan, a canal: Panama";
//        String test = "0P";
//        String test = "a";

        System.out.println(isPalindrome(test));
    }

    //2 ms、38.7 MB
    public static boolean isPalindrome(String s) {
        String temp = s.toLowerCase();
        int p1 = 0;
        int p2 = temp.length() - 1;

        while (p1 < p2) {
            int c1 = temp.charAt(p1);
            int c2 = temp.charAt(p2);

            if (((c1 >= 97 && c1 <= 122) || (c1 >= 48 && c1 <= 57)) &&
                    ((c2 >= 97 && c2 <= 122) || (c2 >= 48 && c2 <= 57))) {
                if (c1 == c2) {
                    p1++;
                    p2--;
                } else {
                    return false;
                }
            } else {
                if (!((c1 >= 97 && c1 <= 122) || (c1 >= 48 && c1 <= 57))) {
                    p1++;
                }
                if (!((c2 >= 97 && c2 <= 122) || (c2 >= 48 && c2 <= 57))) {
                    p2--;
                }
            }
        }
        return true;
    }

    //18 ms、40.1 MB
    public static boolean isPalindrome2(String s) {
        String temp = s.toLowerCase().replaceAll("[^a-z0-9]", "");

        int p1 = 0;
        int p2 = temp.length() - 1;

        while (p1 < p2) {
            if (!(temp.charAt(p1++) == temp.charAt(p2--))) {
                return false;
            }
        }
        return true;
    }
}
