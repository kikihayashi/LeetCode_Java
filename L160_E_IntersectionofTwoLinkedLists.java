package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class L160_E_IntersectionofTwoLinkedLists {

    /**
     * https://leetcode.com/problems/intersection-of-two-linked-lists/
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
        ListNode node0a = new ListNode(1);
        ListNode node1a = new ListNode(2);
        ListNode node2a = new ListNode(3);
        node0a.next = node1a;
        node1a.next = node2a;

        ListNode node0b = new ListNode(4);
        ListNode node1b = new ListNode(5);
        node0b.next = node1b;

        System.out.println(getIntersectionNode4(node0a, node0b));


//        ListNode node0a = new ListNode(1);
//        System.out.println(getIntersectionNode(node0a, node0a).val);
//
//        ListNode node1a = new ListNode(2);
//        ListNode node2a = new ListNode(3);
//        node1a.next = node2a;
//        System.out.println(getIntersectionNode(node1a, node2a).val);

//        ListNode node1b = new ListNode(4);
//        ListNode node2b = new ListNode(1);
//
//        ListNode node0a = new ListNode(5);
//        ListNode node1a = new ListNode(6);
//        ListNode node2a = new ListNode(1);
//
//        ListNode node3 = new ListNode(8);
//        ListNode node4 = new ListNode(4);
//        ListNode node5 = new ListNode(5);
//
//        node1b.next = node2b;
//        node2b.next = node3;
//        node3.next = node4;
//        node4.next = node5;
//
//        node0a.next = node1a;
//        node1a.next = node2a;
//        node2a.next = node3;
//        node3.next = node4;
//        node4.next = node5;
//        System.out.println(getIntersectionNode(node1b, node0a).val);
    }

    //別人寫的：O(n+m)1 ms、41.4 MB
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode ha = headA;
        ListNode hb = headB;
        int lengthA = 0;
        int lengthB = 0;

        while (ha != null) {
            ha = ha.next;
            lengthA++;
        }

        while (hb != null) {
            hb = hb.next;
            lengthB++;
        }

        ha = headA;
        hb = headB;

        if (lengthA > lengthB) {
            for (int i = 0; i < lengthA - lengthB; i++) {
                ha = ha.next;
            }
        } else {
            for (int i = 0; i < lengthB - lengthA; i++) {
                hb = hb.next;
            }
        }

        if (ha == hb) {
            return ha;
        }

        while (ha != hb) {
            ha = ha.next;
            hb = hb.next;
            if (ha == hb) {
                return ha;
            }
        }
        return null;
    }

    //別人寫的：O(n+m)1 ms、41.4 MB
    public static ListNode getIntersectionNode4(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode ha = headA;
        ListNode hb = headB;
        while (ha != hb) {
            ha = (ha == null) ? headB : ha.next;
            hb = (hb == null) ? headA : hb.next;
        }
        return ha;
    }

    //O(n)16 ms、43.6 MB
    public static ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
        ListNode ha = headA;
        ListNode hb = headB;
        HashSet<ListNode> setHa = new HashSet<>();
        HashSet<ListNode> setHb = new HashSet<>();

        while (ha != null || hb != null) {
            if (ha != null) {
                if (setHb.contains(ha)) {
                    return ha;
                }
                setHa.add(ha);
                setHb.add(ha);
                ha = ha.next;
            }
            if (hb != null) {
                if (setHa.contains(hb)) {
                    return hb;
                }
                setHb.add(hb);
                setHa.add(hb);
                hb = hb.next;
            }
        }
        return null;
    }

    //O(n+m)7 ms、43.2 MB
    public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet<>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (set.contains(headB)) {
                System.out.println(set.size());
                return headB;
            } else {
                headB = headB.next;
            }
        }
        return null;
    }
}
