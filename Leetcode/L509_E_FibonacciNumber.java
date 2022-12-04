package Leetcode;

import java.util.HashMap;
import java.util.Map;

public class L509_E_FibonacciNumber {

    /**
     * https://leetcode.com/problems/fibonacci-number/?envType=study-plan&id=level-1
     */

    public static void main(String[] args) {
        int n = 10;
        System.out.println(fib(n));
    }

    public static int fib(int n) {
        if (n <= 1) {
            return n;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        map.put(1, 1);
        for (int i = 2; i <= n; i++) {
            map.put(i, map.get(i - 1) + map.get(i - 2));
        }
        return map.get(n);
    }
}
