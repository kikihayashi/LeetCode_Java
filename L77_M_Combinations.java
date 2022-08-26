package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class L77_M_Combinations {


    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        for (List<Integer> l : combine(n, k)) {
            System.out.println(l);
        }
    }

    public static List<List<Integer>> list;
    public static LinkedList<Integer> subList;

    public static List<List<Integer>> combine(int n, int k) {
        list = new ArrayList<>();
        subList = new LinkedList<>();
        backTracking(1, n, k);
        return list;
    }

    public static void backTracking(int start, int n, int k) {
        if (subList.size() == k) {
            list.add(new ArrayList<>(subList));
            return;
        }
        for (int i = start; i <= n; i++) {
            subList.add(i);
            backTracking(i + 1, n, k);
            subList.removeLast();
        }
    }

}
