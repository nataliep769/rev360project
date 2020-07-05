package com.example.livongoquestion;

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
}
