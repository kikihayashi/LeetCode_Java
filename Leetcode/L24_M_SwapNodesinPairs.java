package Leetcode;

public class L24_M_SwapNodesinPairs {

    /**
     * https://leetcode.com/problems/swap-nodes-in-pairs/
     */

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        ListNode test = swapPairs(node1);
        while (test != null) {
            System.out.println(test.val);
            test = test.next;
        }
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        /**
         * iterativeMethod
         * */
        return iterativeMethod(head);

        /**
         * recursiveMethod
         * */
//        return recursiveMethod(head, head.next);
    }

    //別人寫的
    public static ListNode iterativeMethod(ListNode head) {

        ListNode dummy = new ListNode(0, head);
        ListNode newHead = dummy;

        while (head != null && head.next != null) {
            dummy.next = head.next;
            dummy = head;
            ListNode temp = head.next.next;
            head.next.next = head;
            head.next = temp;
            head = temp;
        }
        return newHead.next;
    }

    public static ListNode recursiveMethod(ListNode firstNode, ListNode secondNode) {
        if (secondNode == null) {
            return firstNode;
        }
        if (secondNode.next != null) {
            firstNode.next = recursiveMethod(secondNode.next, secondNode.next.next);
        } else {
            firstNode.next = null;
        }
        secondNode.next = firstNode;
        return secondNode;
    }


}
