package Leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum/
 */

public class L39_M_CombinationsSum {

    private static List<List<Integer>> result = new LinkedList<>();

    public static void main(String[] args) {
        int[] candidates = new int[]{2, 3, 5};
        int target = 12;
        combinationSum(candidates, target);
        System.out.println(result);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new LinkedList<>();
        backtracking(0, 0, candidates, target, new LinkedList<Integer>());
        return result;
    }

    public static void backtracking(int now, int startIndex, int[] candidates, int target, LinkedList<Integer> list) {
        if (now == target) {
            result.add(new LinkedList<>(list));
            return;
        } else if (now > target) {
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            now += candidates[i];
            list.add(candidates[i]);
            backtracking(now, i, candidates, target, list);
            now -= list.removeLast();
        }
    }
}
