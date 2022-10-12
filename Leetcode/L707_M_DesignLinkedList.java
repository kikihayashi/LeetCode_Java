package Leetcode;

public class L707_M_DesignLinkedList {

    /**
     * https://leetcode.com/problems/design-linked-list/
     */

    //7 ms、39.5 MB(Singly-LinkedList)
    public static class MyLinkedList {

        ListNode head;
        ListNode tail;
        int length;

        public MyLinkedList() {
            head = null;
            tail = null;
            length = 0;
        }

        public int get(int index) {
            if (index >= length || index < 0) {
                return -1;
            }
            ListNode temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            return temp.val;
        }

        public void addAtHead(int val) {
            if (length == 0) {
                head = new ListNode(val);
                tail = new ListNode(val);
            } else if (length == 1) {
                head = new ListNode(val);
                head.next = tail;
            } else {
                ListNode node = new ListNode(val);
                node.next = head;
                head = node;
            }
            length++;
        }

        public void addAtTail(int val) {
            if (length == 0) {
                addAtHead(val);
                return;
            } else if (length == 1) {
                tail = new ListNode(val);
                head.next = tail;
            } else {
                ListNode node = new ListNode(val);
                tail.next = node;
                tail = node;
            }
            length++;
        }

        public void addAtIndex(int index, int val) {
            if (index == 0) {
                addAtHead(val);
            } else if (index == length) {
                addAtTail(val);
            } else if (index > length) {
                return;
            } else {
                ListNode node = new ListNode(val);
                ListNode temp = head;
                for (int i = 0; i < index - 1; i++) {
                    temp = temp.next;
                }
                if (temp.next != null) {
                    node.next = temp.next;
                }
                temp.next = node;
                length++;
            }
        }

        public void deleteAtIndex(int index) {
            if (index < 0 || index >= length) {
                return;
            }
            if (index == 0) {
                head = head.next;
            } else {
                ListNode temp = head;
                for (int i = 0; i < index - 1; i++) {
                    temp = temp.next;
                }
                if (temp.next == tail) {
                    tail = temp;
                    temp.next = null;
                } else {
                    temp.next = temp.next.next;
                }
            }
            length--;
        }
    }

    //9 ms、39.6 MB(Singly-LinkedList)
    public static class MyLinkedList2 {

        ListNode self;
        int length;

        public MyLinkedList2() {
            self = null;
            length = 0;
        }

        public int get(int index) {
            if (index >= length || index < 0) {
                return -1;
            }
            ListNode temp = self;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            return temp.val;
        }

        public void addAtHead(int val) {
            self = new ListNode(val, self);
            length++;
        }

        public void addAtTail(int val) {
            ListNode node = new ListNode(val);
            ListNode temp = self;
            if (self == null) {
                self = node;
            } else {
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = node;
            }
            length++;
        }

        public void addAtIndex(int index, int val) {
            if (index == 0) {
                addAtHead(val);
            } else if (index == length) {
                addAtTail(val);
            } else if (index > length) {
                return;
            } else {
                ListNode node = new ListNode(val);
                ListNode temp = self;
                for (int i = 0; i < index - 1; i++) {
                    temp = temp.next;
                }
                if (temp.next != null) {
                    node.next = temp.next;
                }
                temp.next = node;
                length++;
            }
        }

        public void deleteAtIndex(int index) {
            if (index == 0) {
                self = self.next;
            } else if (index >= length) {
                return;
            } else {
                ListNode temp = self;
                for (int i = 0; i < index - 1; i++) {
                    temp = temp.next;
                }
                temp.next = temp.next.next;
            }
            length--;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode prev;

        ListNode(int val) {
            this.val = val;
            this.next = null;
            this.prev = null;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        ListNode(int val, ListNode prev, ListNode next) {
            this.val = val;
            this.prev = prev;
            this.next = next;
        }

    }

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();

//        myLinkedList.addAtHead(1);
//        myLinkedList.addAtTail(2);
//        myLinkedList.addAtTail(3);
//        myLinkedList.addAtTail(4);
//        myLinkedList.addAtIndex(3, 0);

        //----------------------------------------------

        myLinkedList.addAtHead(86);
        myLinkedList.addAtIndex(1, 54);
        myLinkedList.addAtIndex(1, 14);
        myLinkedList.addAtHead(83);
        myLinkedList.deleteAtIndex(4);
        myLinkedList.addAtIndex(3, 18);
        myLinkedList.addAtHead(46);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtHead(76);
        System.out.println(myLinkedList.get(5));

        //----------------------------------------------

//        myLinkedList.addAtHead(1);
//        myLinkedList.addAtTail(3);
//        myLinkedList.addAtIndex(1, 2);
//        System.out.println(myLinkedList.get(1));
//        myLinkedList.deleteAtIndex(0);
//        System.out.println(myLinkedList.get(0));

        //----------------------------------------------

//        myLinkedList.addAtHead(1);
//        myLinkedList.addAtTail(3);
//        myLinkedList.addAtIndex(1, 2);
//        System.out.println(myLinkedList.get(1));
//        myLinkedList.deleteAtIndex(1);
//        System.out.println(myLinkedList.get(1));

        //----------------------------------------------

//        myLinkedList.addAtHead(7);
//        myLinkedList.addAtHead(2);
//        myLinkedList.addAtHead(1);
//        myLinkedList.addAtIndex(3, 0);
//        myLinkedList.deleteAtIndex(2);
//        myLinkedList.addAtHead(6);
//        myLinkedList.addAtTail(4);
//        System.out.println(myLinkedList.get(4));
//        myLinkedList.addAtHead(4);
//        myLinkedList.addAtIndex(5, 0);
//        myLinkedList.addAtHead(6);

        //----------------------------------------------

        System.out.println("------------------");
        System.out.println(myLinkedList.get(0));
        System.out.println(myLinkedList.get(1));
        System.out.println(myLinkedList.get(2));
        System.out.println(myLinkedList.get(3));
        System.out.println(myLinkedList.get(4));
        System.out.println(myLinkedList.get(5));
        System.out.println(myLinkedList.get(6));
    }
}
