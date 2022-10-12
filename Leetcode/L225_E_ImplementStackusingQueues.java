package Leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class L225_E_ImplementStackusingQueues {

    /**
     * https://leetcode.com/problems/implement-stack-using-queues/
     */

    public static void main(String[] args) {

        MyStack obj = new MyStack();
        obj.push(1);
        obj.push(2);
        int param_2 = obj.top();
        int param_3 = obj.pop();
        boolean param_4 = obj.empty();
        System.out.println(param_2);
        System.out.println(param_3);
        System.out.println(param_4);
    }

    static class MyStack {

        Queue<Integer> queue;

        public MyStack() {
            queue = new LinkedList<>();
        }

        public void push(int x) {
            queue.offer(x);
        }

        public int pop() {
            if (queue.size() != 1) {
                for (int i = 0; i < queue.size() - 1; i++) {
                    int temp = queue.poll();
                    queue.add(temp);
                }
            }
            return queue.poll();
        }

        public int top() {
            int top = 0;
            if (queue.size() != 1) {
                for (int i = 0; i < queue.size() - 1; i++) {
                    int temp = queue.poll();
                    queue.add(temp);
                }
                top = queue.poll();
                queue.add(top);
            } else {
                top = queue.peek();
            }
            return top;
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }
}
