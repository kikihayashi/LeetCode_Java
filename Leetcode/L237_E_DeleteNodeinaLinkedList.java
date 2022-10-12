package Leetcode;

public class L237_E_DeleteNodeinaLinkedList {
    /**
     * https://leetcode.com/problems/reverse-linked-list/
     */

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        //別人寫的
        void deleteNode(ListNode node) {
            node.val = node.next.val;
            node.next = node.next.next;
        }

        void deleteNode2(ListNode node) {
            node.val = node.next.val;
            if (node.next != null && node.next.next != null) {
                deleteNode(node.next);
            } else {
                node.next = null;
                return;
            }
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(2);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;

        l1.deleteNode(l2);

        System.out.println(l1.val);
        System.out.println(l1.next.val);
        System.out.println(l1.next.next.val);
//        System.out.println(l1.next.next.next.val);
    }




}
