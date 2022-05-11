package com.ilya.coding;

import java.util.List;

public class ReverseLinkedList {
    /**
     * Reverses a given linked list iteratively
     * @param head
     * @return head of
     */
    public static ListNode reverseList(ListNode head) {
        // error checking
        if (head == null) {
            return head;
        }

        // init variables
        ListNode prev = null;
        ListNode cur;

        while (head != null) {
            cur = head;
            head = head.next;
            cur = cur.next;
            prev = cur;
        }

        return prev;
    }

    public static ListNode reverseListRec(ListNode head) {
        // error checking
        if (head == null) {
            return head;
        }

        return reverseListRec(null, head);
    }

    private static ListNode reverseListRec(ListNode prev, ListNode cur) {
        // error checking
        if (cur == null) {
            return prev;
        }

        ListNode next = cur.next;
        cur.next = prev;

        return reverseListRec(cur, next);
    }

}
