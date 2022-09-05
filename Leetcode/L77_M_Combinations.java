package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/combinations/
 */

public class L77_M_Combinations {

    private static List<List<Integer>> result = new LinkedList<>();

    public static void main(String[] args) {
        combine(6, 3);
        System.out.println(result);
    }

    public static List<List<Integer>> combine(int n, int k) {
        result = new LinkedList<>();
        backtrackingMy(1, n, k, new LinkedList<>());
        return result;
    }

    //別人寫的：2 ms、45.3 MB
    public static void backtracking(int start, int n, int k, LinkedList<Integer> list) {
        if (list.size() == k) {
            result.add(new LinkedList<>(list));
            return;
        }

        for (int i = start; i <= n - (k - list.size()) + 1; i++) {
            list.add(i);
            backtracking(i + 1, n, k, list);
            list.remove(list.size() - 1);
        }
    }

    //81 ms、65.4 MB
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
