package LeetCode;

import java.util.Stack;

public class L232_E_ImplementQueueusingStacks {

    /**
     * https://leetcode.com/problems/implement-queue-using-stacks/
     */

    public static void main(String[] args) {

        MyQueue obj = new MyQueue();
        obj.push(1);
        obj.push(2);
        int param_2 = obj.peek();
        int param_3 = obj.pop();
        boolean param_4 = obj.empty();
        System.out.println(param_2);
        System.out.println(param_3);
        System.out.println(param_4);
    }

    //0 ms、38.1 MB
    static class MyQueue {

        public Stack<Integer> stackPop;
        public Stack<Integer> stackPush;

        public MyQueue() {
            stackPop = new Stack<>();
            stackPush = new Stack<>();
        }

        public void push(int x) {
            stackPush.push(x);
        }

        private void makePopStack() {
            while (!stackPush.isEmpty()) {
                stackPop.add(stackPush.pop());
            }
        }

        public int pop() {
            if (stackPop.isEmpty()) {
                makePopStack();
            }
            return stackPop.pop();
        }

        public int peek() {
            if (stackPop.isEmpty()) {
                makePopStack();
            }
            return stackPop.peek();
        }

        public boolean empty() {
            return stackPop.isEmpty() && stackPush.isEmpty();
        }
    }

    //1 ms、38.1 MB
    static class MyQueue2 {

        public Stack<Integer> stackPop;
        public Stack<Integer> stackPush;

        public MyQueue2() {
            stackPop = new Stack<>();
            stackPush = new Stack<>();
        }

        public void push(int x) {
            makePushStack();
            stackPush.push(x);
            makePopStack();
        }

        private void makePushStack() {
            while (stackPop.size() > 0) {
                stackPush.add(stackPop.pop());
            }
        }

        private void makePopStack() {
            while (stackPush.size() > 0) {
                stackPop.add(stackPush.pop());
            }
        }

        public int pop() {
            return stackPop.pop();
        }

        public int peek() {
            return stackPop.peek();
        }

        public boolean empty() {
            return stackPop.size() == 0;
        }
    }
}



