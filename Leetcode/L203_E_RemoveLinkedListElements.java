package Leetcode;

public class L203_E_RemoveLinkedListElements {

    /**
     * https://leetcode.com/problems/remove-linked-list-elements/
     */

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(6);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(5);
        ListNode node7 = new ListNode(6);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        ListNode test = removeElements(node1, 1);

        while (test != null) {
            System.out.println(test.val);
            test = test.next;
        }
    }

    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        if (head.val == val) {
            return removeElements(head.next, val);
        } else {
            head.next = removeElements(head.next, val);
            return head;
        }
    }

    //iterative 別人寫的
    public static ListNode removeElements2(ListNode head, int val) {
        while (head != null && val == head.val) {
            head = head.next;
        }
        ListNode tempNode = head;
        while (tempNode != null && tempNode.next != null) {
            if (tempNode.next.val == val) {
                tempNode.next = tempNode.next.next;
            } else {
                tempNode = tempNode.next;
            }
        }
        return head;
    }





}
