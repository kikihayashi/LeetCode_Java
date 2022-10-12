package Leetcode;

import java.util.*;

/**
 * https://leetcode.com/problems/combination-sum-ii/
 */

public class L40_M_CombinationsSumII {

    private static List<List<Integer>> result;
    private static int matchListValue = 0;

    public static void main(String[] args) {
        int[] candidates = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        int target = 30;
/**
        int[] candidates = new int[]{10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        int[] candidates = new int[]{2, 5, 2, 1, 2};
        int target = 5;
*/
        combinationSum2(candidates, target);
        System.out.println(result);
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        matchListValue = 0;
        result = new LinkedList<>();
        backtracking(0, 0, candidates, target, new LinkedList<>());
        return result;
    }

    public static void backtracking(int now, int startIndex, int[] candidates, int target, LinkedList<Integer> list) {
        if (now == target) {
            matchListValue = list.getFirst();
            result.add(new LinkedList<>(list));
            return;
        } else if (now > target) {
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            if (matchListValue == candidates[i]) {
                continue;
            }
            now += candidates[i];
            list.add(candidates[i]);
            backtracking(now, i + 1, candidates, target, list);
            matchListValue = list.getLast();
            now -= list.removeLast();
        }
    }
}
