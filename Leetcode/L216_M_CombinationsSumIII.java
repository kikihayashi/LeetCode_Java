package Leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum-iii/
 */

public class L216_M_CombinationsSumIII {

    private static List<List<Integer>> result;

    public static void main(String[] args) {
        int k = 3;
        int n = 9;
        combinationSum3(k, n);
        System.out.println(result);
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        result = new LinkedList<>();
        backtracking(0, 1, k, n, new LinkedList<>());
        return result;
    }

    public static void backtracking(int now, int startValue, int listSize, int target, LinkedList<Integer> list) {
        if (now > target) {
            return;
        }
        if (list.size() == listSize) {
            if (now == target) {
                result.add(new LinkedList<>(list));
            }
            return;
        }
        for (int i = startValue; i <= 9; i++) {
            now += i;
            list.add(i);
            backtracking(now, i + 1, listSize, target, list);
            now -= list.removeLast();
        }
    }
}
