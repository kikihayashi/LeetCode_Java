package Leetcode;

public class L326_E_PowerofThree {

    /**
     * https://leetcode.com/problems/power-of-three/
     */


    public static void main(String[] args) {

        int test = 0;

//        System.out.println(Math.pow(3,5));
        System.out.println(Math.log10(3));
        System.out.println(Math.log10(243));

        System.out.println(isPowerOfThree(test));
    }

    //別人寫的：10 ms	38.8 MB
    public static boolean isPowerOfThree(int n) {
        while (n >= 3) {
            if (n % 3 != 0){
                return false;
            }
            n /= 3;
        }
        return n == 1;
    }

    //24 ms、43.9 MB
    public static boolean isPowerOfThree2(int n) {
        if (n == 0) {
            return false;
        }
        int result = (int) Math.pow(3, (int) (Math.log10(n) / Math.log10(3)));
        return (result == n || result * 3 == n);
    }
}
