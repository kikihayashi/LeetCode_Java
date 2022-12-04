package Leetcode;

import javax.print.attribute.IntegerSyntax;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class L1046_E_LastStoneWeight {

    /**
     * https://leetcode.com/problems/last-stone-weight/
     */

    public static void main(String[] args) {
//        int[] stones = new int[]{2, 7, 4, 1, 8, 1};
        int[] stones = new int[]{1,1};
        System.out.println(lastStoneWeight(stones));
    }

    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(stones.length, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int stone : stones) {
            queue.offer(stone);
        }
        while (queue.size() > 1) {
            int max1 = queue.poll();
            int max2 = queue.poll();
            queue.offer(max1 - max2);
        }
        return queue.poll();
    }
}
