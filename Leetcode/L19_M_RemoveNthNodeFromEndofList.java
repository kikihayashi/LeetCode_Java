package LeetCode;

public class L19_M_RemoveNthNodeFromEndofList {

    /**
     * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
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

        int n = 1;

        ListNode test = removeNthFromEnd(node1, n);
        while (test != null) {
            System.out.println(test.val);
            test = test.next;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int leadIndex = 0;
        ListNode fastNode = head;
        ListNode slowNode = head;
        while (leadIndex++ < n) {
            fastNode = fastNode.next;
        }
        if (fastNode == null) {
            return head.next;
        }
        while (fastNode.next != null) {
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }
        slowNode.next = slowNode.next.next;

        return head;
    }


    public static int length;

    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode reverseNode = reverse(head);
        ListNode temp = reverseNode;

        if (n == 1) {
            if (length == 1) {
                return null;
            }
            return reverse(reverseNode.next);
        }
        for (int i = 0; i < n - 2; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return reverse(reverseNode);
    }

    public static ListNode reverse(ListNode head) {
        length = 0;
        if (head == null) {
            return null;
        }

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
            length++;
        }
        return prev;
    }


}
