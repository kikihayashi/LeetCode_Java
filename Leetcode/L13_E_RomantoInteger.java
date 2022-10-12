package Leetcode;

import java.util.HashMap;

public class L13_E_RomantoInteger {

    /**
     * https://leetcode.com/problems/roman-to-integer/
     */


    public static void main(String[] args) {
        String test = "LVIII";//58
//        String test = "MCMXCIV";//1994

//        System.out.println(Roman.C.getValueByName('M'));
        System.out.println(romanToInt(test));
    }

    //('I', 'V', 'X', 'L', 'C', 'D', 'M')
    public static HashMap<Character, Integer> map = new HashMap<>() {
        {
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }
    };

    public static int romanToInt(String s) {
        char[] c = s.toCharArray();
        int prevValue = map.get(c[c.length - 1]);
        int finalValue = prevValue;

        for (int i = c.length - 2; i >= 0; i--) {
            finalValue += ((prevValue <= map.get(c[i])) ? map.get(c[i]) : -1 * map.get(c[i]));
            prevValue = map.get(c[i]);
        }
        return finalValue;
    }
}
