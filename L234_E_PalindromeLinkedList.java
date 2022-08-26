package LeetCode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class L234_E_PalindromeLinkedList {

    /**
     * https://leetcode.com/problems/palindrome-linked-list/
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
        ListNode l0 = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))));
        ListNode l1 = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(1))));
        ListNode l15 = new ListNode(1, new ListNode(2, new ListNode(1, new ListNode(1))));
        ListNode l2 = new ListNode(4, new ListNode(3, new ListNode(1, new ListNode(3, new ListNode(4)))));
        ListNode l3 = new ListNode(3, new ListNode(2));
        ListNode l4 = new ListNode(2, new ListNode(1));
        ListNode l5 = new ListNode(2);

        System.out.println(isPalindrome(l0));
        System.out.println(isPalindrome(l1));
        System.out.println(isPalindrome(l15));
        System.out.println(isPalindrome(l2));
        System.out.println(isPalindrome(l3));
        System.out.println(isPalindrome(l4));
        System.out.println(isPalindrome(l5));
    }

    //4ms、49.1MB，參考https://leetcode.com/problems/palindrome-linked-list/discuss/1332877/Java-solution-O(N)-98?fbclid=IwAR0MbmC_k6hPspTHoc4QSRE3pTwITKnUvpkRznJQLFTtMM7HVd4yfNg3qOU
    public static boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        if (fast.next != null) {
            slow = slow.next;
        }
        ListNode reverse = reverseNode(slow);

        while (reverse != null) {
            if (head.val != reverse.val) {
                return false;
            }
            head = head.next;
            reverse = reverse.next;
        }
        return true;
    }

    public static ListNode reverseNode(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    //50ms、116.4MB
    public static boolean isPalindrome2(ListNode head) {
        List<Integer> list = new LinkedList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        while (list.size() > 1) {
            if (list.get(0) == list.get(list.size() - 1)) {
                list.remove(0);
                list.remove(list.size() - 1);
            } else {
                return false;
            }
        }
        return true;
    }

    //92ms、62.9MB
    public static boolean isPalindrome3(ListNode head) {
        List<Integer> sb = new LinkedList<>();
        List<Integer> sbr = new LinkedList<>();

        while (head != null) {
            sb.add(head.val);
            sbr.add(0, head.val);
            head = head.next;
        }
        return sb.toString().equals(sbr.toString());
    }

    //28ms、123MB
    public static boolean isPalindrome4(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val);
            head = head.next;
        }
        return sb.toString().equals(sb.reverse().toString());
    }
}
