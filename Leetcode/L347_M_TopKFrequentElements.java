package Leetcode;

import java.util.*;

public class L347_M_TopKFrequentElements {

    /**
     * https://leetcode.com/problems/top-k-frequent-elements/
     */

    public static void main(String[] args) {

        int[] test = new int[]{1, 1, 1, 1, 1, 2, 2, 2, 0, 3, 3};//3,1
        int n = 2;

        System.out.println(Arrays.toString(topKFrequent3(test, n)));
    }

    //參考別人寫的：9 ms、41.7 MB
    public static int[] topKFrequent3(int[] nums, int k) {
        int[] result = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();

        //從小到大
        Comparator<Map.Entry<Integer, Integer>> comparator = (o1, o2) -> o1.getValue() - o2.getValue();
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(comparator);

        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            pq.offer(e);
            if (pq.size() > k) {
                pq.poll();
            }
            System.out.println(pq);
        }
        for (int i = 0; i < k; i++) {
            result[i] = pq.poll().getKey();
        }
        return result;
    }

    public static int[] topKFrequent2(int[] nums, int k) {
        int[] result = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1) - map.get(o2);
            }
        });

        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            pq.add(e.getKey());
        }
        int index = 0;
        while (!pq.isEmpty()) {
            if (pq.size() > k) {
                pq.poll();
            } else {
                result[index++] = pq.poll();
            }
        }
        return result;
    }

}




