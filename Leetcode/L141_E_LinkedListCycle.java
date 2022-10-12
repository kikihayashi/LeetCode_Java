package Leetcode;

public class L141_E_LinkedListCycle {

    /**
     * https://leetcode.com/problems/linked-list-cycle/
     */

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {

        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;

        System.out.println(hasCycle(node1));
    }

    //要使用two pointer概念
    public static boolean hasCycle(ListNode head) {
        //先設置起點(快的慢的一樣)
        ListNode fast = head;
        ListNode slow = head;

        //如果快的當前以及下一個不是最末點
        while (fast != null && fast.next != null) {
            //快的往後走兩格
            fast = fast.next.next;
            //快的往後走一格
            slow = slow.next;

            //如果有交會，代表有環
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
