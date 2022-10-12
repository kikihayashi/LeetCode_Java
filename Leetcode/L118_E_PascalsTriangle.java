package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class L118_E_PascalsTriangle {

    /**
     * https://leetcode.com/problems/pascals-triangle/
     */

    public static void main(String[] args) {
        int test = 10;
        System.out.println(generate(test));
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangleList = new ArrayList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        list1.add(1);
        list2.add(1);
        list2.add(1);
        map.put(1, list1);
        map.put(2, list2);

        for (int i = 1; i <= numRows; i++) {
            if (!map.containsKey(i)) {
                List<Integer> list = getCombineList(map.get(i - 1));
                map.put(i, list);
            }
            triangleList.add(map.get(i));
        }
        return triangleList;
    }

    private static List<Integer> getCombineList(List<Integer> list) {
        List<Integer> newList = new ArrayList<>();
        for (int i = 0; i < list.size() - 1; i++) {
            newList.add(list.get(i) + list.get(i + 1));
        }
        newList.add(1);
        newList.add(0, 1);
        return newList;
    }
}
