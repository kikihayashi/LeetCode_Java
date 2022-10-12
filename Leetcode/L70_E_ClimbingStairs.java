package Leetcode;

import java.util.HashMap;

public class L70_E_ClimbingStairs {

    /**
     * https://leetcode.com/problems/climbing-stairs/
     */

    public static void main(String[] args) {

        int test = 4;

        System.out.println(climbStairs(test));
    }

    public static int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.put(2, 2);
        for (int i = 3; i <= n; i++) {
            map.put(i, map.get(i - 1) + map.get(i - 2));
        }
        return map.get(n);
    }
}
