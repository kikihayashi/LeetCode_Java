package LeetCode;

public class L191_E_Numberof1Bits {

    /**
     * https://leetcode.com/problems/number-of-1-bits/
     */

    public static void main(String[] args) {
        int test = -3;
        System.out.println(hammingWeight(-3));
    }

    //9 ms、37.3 MB
    public static int hammingWeight(int n) {
        return Integer.toUnsignedString(n, 2).replaceAll("0", "").length();
    }

    //別人寫的1 ms、38.1 MB
    //https://leetcode.com/problems/number-of-1-bits/discuss/1519675/JAVA-C%2B%2B-%3A-Simple-or-O(1)-Time-or-Faster-than-100-or-Detailed-Explanation
    public static int hammingWeight2(int n) {
        int count = 0;
        while (n != 0) {
            n &= (n - 1);
            count++;
        }
        return count;
    }


}
