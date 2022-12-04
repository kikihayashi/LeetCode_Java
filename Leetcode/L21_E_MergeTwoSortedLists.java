package Leetcode;

public class L21_E_MergeTwoSortedLists {

    /**
     * https://leetcode.com/problems/merge-two-sorted-lists/submissions/
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
        ListNode l1 = new ListNode(-9, new ListNode(5));
        ListNode l2 = new ListNode(3, new ListNode(7));
        ListNode l3 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode l4 = new ListNode(1, new ListNode(3, new ListNode(4)));

        System.out.println(mergeTwoLists(l1, l2).val);
        System.out.println(mergeTwoLists(l1, l2).next.val);
        System.out.println(mergeTwoLists(l1, l2).next.next.val);
        System.out.println(mergeTwoLists(l1, l2).next.next.next.val);
    }


    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            return new ListNode(l1.val, mergeTwoLists(l1.next, l2));
        } else {
            return new ListNode(l2.val, mergeTwoLists(l1, l2.next));
        }
    }
}
