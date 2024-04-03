package LeetCode;

public class L206_E_ReverseLinkedList {

    /**
     * https://leetcode.com/problems/reverse-linked-list/
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
        ListNode l1 = new ListNode(5, new ListNode(4));
        ListNode l2 = new ListNode(4, new ListNode(3));
        ListNode l3 = new ListNode(3, new ListNode(2));
        ListNode l4 = new ListNode(2, new ListNode(1));

        System.out.println(reverseList(l1).val);
        System.out.println(reverseList(l2).next.val);
        System.out.println(reverseList(l3).next.next.val);
        System.out.println(reverseList(l4).next.next.next.val);
    }

    public static ListNode reverseList(ListNode head) {
        /**
         *  iterativeMethod
         */
        return iterativeMethod(head);

        /**
         *  recursiveMethod
         */
//        return recursiveMethod(head, null);

    }

    //看別人寫的
    //https://algorithm.yuanbin.me/zh-tw/linked_list/reverse_linked_list.html
    public static ListNode iterativeMethod(ListNode head) {
        ListNode prevNode = null;
        ListNode currNode = head;

        while (currNode != null) {
            ListNode nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        }
        return prevNode;
    }

    public static ListNode recursiveMethod(ListNode currNode, ListNode prevNode) {
        if (currNode == null) {
            return prevNode;
        }

        ListNode nextNode = currNode.next;
        currNode.next = prevNode;
        prevNode = currNode;
        currNode = nextNode;

        return recursiveMethod(currNode, prevNode);
    }

}
