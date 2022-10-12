package Leetcode;

import java.util.HashMap;

public class L202_E_HappyNumber {

    /**
     * https://leetcode.com/problems/happy-number/
     */

    public static void main(String[] args) {
        int test = 23;
        System.out.println(isHappy(test));
    }

    public static HashMap<Integer, Boolean> map = new HashMap<>();

    public static boolean isHappy(int n) {
        if (map.containsKey(n) && map.get(n)) {
            map.clear();
            return false;
        }
        int value = 0;
        int temp = n;

        while (temp > 0) {
            int rem = temp % 10;
            temp = temp / 10;
            value += rem * rem;
        }
//        for (char c : String.valueOf(n).toCharArray()) {
//            value += Character.getNumericValue(c) * Character.getNumericValue(c);
//        }

        if (value == 1) {
            return true;
        } else {
            map.put(n, true);
            return isHappy(value);
        }
    }
}
