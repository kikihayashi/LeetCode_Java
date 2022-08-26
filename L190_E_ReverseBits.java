package LeetCode;

public class L190_E_ReverseBits {

    /**
     * https://leetcode.com/problems/reverse-bits/
     */

    public static void main(String[] args) {
//        int test = 43261596;
        int test = -3;
//        String s = "00000010100101000001111010011100";
//        String s = "00111001011110000010100101000000";
//        String s = "11111111111111111111111111111101";
//        String s = "10111111111111111111111111111111";

//        System.out.println(test);
//        System.out.println(reverseBits(test));
//        System.out.println(Integer.toBinaryString(-3));
//        System.out.println(get32Bit(test));
//        System.out.println(getNumber(s));

//        System.out.println("-3  ：" + Integer.toBinaryString(-3));
//
//        System.out.println("~-3 ：" + "000000000000000000000000000000" + Integer.toBinaryString(2));
//
//
//        System.out.println("~ ：" + (~-3 + 1));
//
//        System.out.println("  3 ：" + "000000000000000000000000000000" + Integer.toBinaryString(3));


//        System.out.println(Integer.toUnsignedString(-3));
//        System.out.println(Integer.toUnsignedLong(-3));
//        System.out.println(Integer.toHexString(-3));
        System.out.println(reverseBits2(1));


    }

    public static int reverseBits2(int n) {
        int rev = 0;
        int r = 31;
        do {
            final int vbit = n & 1;//&代表，2者都要是1才是1，其餘為0
            n >>= 1;//n = n/2
            rev |= vbit << r;//vbit*(2^r)，|代表只要有1就是1，其餘為0
        } while (r-- > 0);
        return rev;
    }

    public static int reverseBits(int n) {
        String temp = Integer.toBinaryString(n);
        while (temp.length() < 32) {
            temp = "0" + temp;
        }
        System.out.println("原始：" + temp);
        StringBuilder sb = new StringBuilder(temp);
        sb.reverse();
        System.out.println("鏡射：" + sb.toString());
        return Integer.parseUnsignedInt(sb.toString(), 2);
    }

    public static int getNumber(String str) {
        int temp = 0;
        //負的
        if (str.charAt(0) == 49) {
            for (int i = 1; i < str.length(); i++) {
                temp += Math.pow(2, str.length() - 1 - i) * (str.charAt(i) - 48);
            }
            return temp * -1;
        } else {
            for (int i = 0; i < str.length(); i++) {
                temp += Math.pow(2, str.length() - 1 - i) * (str.charAt(i) - 48);
            }
            return Integer.parseUnsignedInt(str);
        }
    }


    public static int getNumber2(String str) {
        int temp = 0;
        //負的
        if (str.charAt(0) == 49) {
            for (int i = 1; i < str.length(); i++) {
                temp += Math.pow(2, str.length() - 1 - i) * (str.charAt(i) - 48);
            }
            return temp * -1;
        } else {
            for (int i = 0; i < str.length(); i++) {
                temp += Math.pow(2, str.length() - 1 - i) * (str.charAt(i) - 48);
            }
            return Integer.parseUnsignedInt(str);
        }
    }

    public static String get32Bit(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 1) {
            sb.append(n % 2);
            n = n / 2;
        }
        sb.append(1);

        while (sb.length() < 32) {
            sb.append(0);
        }
        return sb.toString();
    }
}
