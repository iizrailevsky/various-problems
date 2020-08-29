package com.ilya.coding;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNull;

import org.junit.Test;


public class ReverseLinkedListTest {
    @Test
    public void testEmpty() {
        assertNull(ReverseLinkedList.reverseList(null));
        assertNull(ReverseLinkedList.reverseListRec(null));
    }

    @Test
    public void testOne() {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

        // reverse iteratively
        assertEquals(5, ReverseLinkedList.reverseList(head).val);

        // reverse back recursively
        assertEquals(1, ReverseLinkedList.reverseListRec(head).val);
    }
}
