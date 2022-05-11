package com.ilya.coding;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class LinkedListSumOfValuesTest {

    @Test
    public void testEmpty() {
        assertEquals(0, LinkedListSumOfValues.sumOfValuesRec(null));
        assertEquals(5, LinkedListSumOfValues.sumOfValuesRec(new ListNode(5)));
    }

    @Test
    public void testOne() {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

        // sum up recursively
        assertEquals(15, LinkedListSumOfValues.sumOfValuesRec(head));
    }
}
