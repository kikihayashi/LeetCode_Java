package Leetcode;

import java.util.*;

public class L155_E_MinStack {

    /**
     * https://leetcode.com/problems/min-stack/
     */

    public static void main(String[] args) {

//        PriorityQueue<Integer> p = new PriorityQueue<>();
//
//        p.add(-88);
//        p.add(8);
//        p.add(11);
//        p.add(-199);
//        p.add(0);
//        p.add(360);
//        System.out.println(p);

        MinStack obj = new MinStack();
        obj.push(-1999);
        obj.push(-88);
        obj.push(-11);
        obj.push(11);
        obj.push(88);
        obj.push(-1999);
        obj.push(-1999);
        obj.push(-1999);

        obj.pop();
        obj.pop();
        obj.pop();
        obj.pop();
        obj.pop();
        int param_3 = obj.top();
        int param_4 = obj.getMin();

//        System.out.println(param_3);
        System.out.println(param_4);
    }

    public static class MinStack {
        List<Integer> list;
        TreeSet<Integer> set;
        HashMap<Integer, Integer> map;

        public MinStack() {
            list = new LinkedList<>();
            set = new TreeSet<>();
            map = new HashMap<>();
        }

        public void push(int val) {
            list.add(val);
            set.add(val);
            if (map.containsKey(val)) {
                map.put(val, map.get(val) + 1);
            } else {
                map.put(val, 1);
            }
        }

        public void pop() {
            int popValue = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            if (map.get(popValue) == 1) {
                set.remove(popValue);
                map.remove(popValue);
            } else {
                map.put(popValue, map.get(popValue) - 1);
            }

        }

        public int top() {
            return list.get(list.size() - 1);
        }

        public int getMin() {
            return set.iterator().next();
        }
    }
}
