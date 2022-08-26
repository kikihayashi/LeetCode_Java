package LeetCode;

import java.util.*;

public class L239_H_SlidingWindowMaximum {

    /**
     * https://leetcode.com/problems/sliding-window-maximum/
     */

    public static void main(String[] args) {
//        int[] test = new int[]{1, -1};
//        int n = 1;
//        int[] test = new int[]{7, 2, 4};
//        int n = 2;
        int[] test = new int[]{1, 3, 1, 2, 0, 5};
        int n = 3;
//        int[] test = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
//        int n = 3;

        System.out.println(Arrays.toString(maxSlidingWindow(test, n)));
    }

    //自定義一個單調排隊 MonotonicQueue
    static class MonotonicQueue {

        Deque<Integer> deque;

        MonotonicQueue() {
            deque = new ArrayDeque<>();
        }

        //新增sliding-window的值
        public void push(int value) {
            while (deque.size() != 0 && value > deque.peekLast()) {
                deque.pollLast();
            }
            deque.add(value);
        }

        //移除sliding-window的值
        public void pop(int value) {
            if (value == deque.peekFirst()) {
                deque.pollFirst();
            }
        }

        //回傳最大值
        public int getMax() {
            return deque.getFirst();
        }
    }

    //https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0239.%E6%BB%91%E5%8A%A8%E7%AA%97%E5%8F%A3%E6%9C%80%E5%A4%A7%E5%80%BC.md
    //別人寫的：34 ms、54 MB
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        int index = 0;
        MonotonicQueue mq = new MonotonicQueue();

        //先將窗口的值存入單調排隊
        for (int i = 0; i < k; i++) {
            mq.push(nums[i]);
        }
        //存入第一個最大值
        result[index++] = mq.getMax();

        //開始往右邊移動
        for (int i = k; i < nums.length; i++) {
            //先放入右邊的值
            mq.push(nums[i]);
            //再移除左邊的值
            mq.pop(nums[i - k]);
            //存入下一個最大值
            result[index++] = mq.getMax();
        }
        return result;
    }
}
