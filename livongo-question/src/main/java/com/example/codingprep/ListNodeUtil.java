package com.example.codingprep;

public class ListNodeUtil {

    public static ListNode findMiddleNode(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (head.next != null && head.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;

    }

    public static ListNode deleteAtTail(ListNode head) {

        ListNode subsequent = head.next;

        while (subsequent != head) {
            subsequent = subsequent.next;
        }

        subsequent = null;

        return head;
    }


}
