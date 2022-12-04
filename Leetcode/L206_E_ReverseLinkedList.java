package Leetcode;

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
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(2);
        ListNode l5 = new ListNode(1);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        ListNode result = reverseList(l1);
//        ListNode result = reverseList2(l1);

        System.out.println(result.val);
        System.out.println(result.next.val);
        System.out.println(result.next.next.val);
    }

    public static ListNode reverseList(ListNode head) {
//        return recursiveM(head, null);
        return iterativeM(head);
    }

    private static ListNode recursiveM(ListNode currentNode, ListNode prevNode) {
        if (currentNode == null) {
            return prevNode;
        }
        ListNode tempNode = currentNode;
        currentNode = currentNode.next;
        tempNode.next = prevNode;
        prevNode = tempNode;
        return recursiveM(currentNode, prevNode);
    }

    private static ListNode iterativeM(ListNode currentNode) {
        ListNode prevNode = null;
        while (currentNode != null) {
            ListNode tempNode = currentNode;
            currentNode = currentNode.next;
            tempNode.next = prevNode;
            prevNode = tempNode;
        }
        return prevNode;
    }


    public static ListNode reverseList2(ListNode head) {
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
