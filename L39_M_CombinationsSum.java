package Leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum/
 */

public class L39_M_CombinationsSum {

    private static List<List<Integer>> result = new LinkedList<>();

    public static void main(String[] args) {
        int[] candidates = new int[]{2, 3, 5};
        int target = 8;
        combinationSum(candidates, target);
//        System.out.println(8%2);
        System.out.println(result);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtracking(0, 0, candidates, target, new LinkedList<Integer>());
        return result;
    }

    public static void backtracking(int start, int now, int[] candidates, int target, LinkedList<Integer> list) {
        if (now == target) {
            result.add(new LinkedList<>(list));
            return;
        } else if (now > target) {
            now -= candidates[start + 1];
            list.removeLast();
        }

        for (int i = start; i < candidates.length; i++) {
            list.add(candidates[i]);
            now += candidates[i];
            backtracking(start, now, candidates, target, list);
            list.removeLast();
        }
        list.removeLast();
        backtracking(start + 1, now, candidates, target, list);

    }

    public static void backtrackingMy(int start, int n, int k, LinkedList<Integer> list) {
        if (list.size() == k) {
            result.add(new LinkedList<>(list));
            return;
        }

        for (int i = start; i <= n; i++) {
            if (list.size() == 0 || list.getLast() < i) {
                list.add(i);
                backtrackingMy(i + 1, n, k, list);
                list.remove(list.size() - 1);
            }
        }
    }

    public static void backtracking1(int n, int k) {
        List list = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            list.add(i);
            result.add(List.copyOf(list));
            list.remove(list.size() - 1);
        }
    }

    public static void backtracking2(int n, int k) {
        List list = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            list.add(i);
            for (int j = i + 1; j <= n; j++) {
                list.add(j);
                result.add(List.copyOf(list));
                list.remove(list.size() - 1);
            }
            list.remove(list.size() - 1);
        }
    }

    public static void backtracking3(int n, int k) {
        List list = new LinkedList<>();

        for (int p = 1; p <= n; p++) {
            list.add(p);
            for (int i = p + 1; i <= n; i++) {
                list.add(i);
                for (int j = i + 1; j <= n; j++) {
                    list.add(j);
                    result.add(List.copyOf(list));
                    list.remove(list.size() - 1);
                }
                list.remove(list.size() - 1);
            }
            list.remove(list.size() - 1);
        }
    }

}
