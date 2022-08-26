package LeetCode;

public class L142_M_LinkedListCycleII {

    /**
     * https://leetcode.com/problems/linked-list-cycle-ii/
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

        ListNode node1a = new ListNode(1);
        ListNode node2a = new ListNode(2);

        node1a.next = node2a;
        node2a.next = node1a;

        System.out.println(detectCycle2(node1a).val);

        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;

        System.out.println(detectCycle2(node1).val);
    }

    public static ListNode detectCycle2(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            //如果有環
            if (fast == slow) {
                //設置一個頭節點
                ListNode temp = head;
                //將當下的節點與頭節點，一步步推進，相等時即為環入口
                while (temp != fast) {
                    temp = temp.next;
                    fast = fast.next;
                }
                return temp;
            }
        }
        return null;
    }


    public static ListNode detectCycle(ListNode head) {
        while (head != null) {
            if (hasCycle(head)) {
                return head;
            }
            head = head.next;
        }
        return null;
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
                return fast == head;
            }
        }
        return false;
    }


}
