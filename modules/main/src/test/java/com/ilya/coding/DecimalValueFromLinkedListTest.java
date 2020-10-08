package com.ilya.coding;

import org.junit.Test;

import static org.junit.Assert.*;

public class DecimalValueFromLinkedListTest {

    @Test
    public void testEmpty() {
        assertEquals(-1, DecimalValueFromLinkedList.getDecimalValue(null));
    }

    @Test
    public void testOne() {
        ListNode l = new ListNode(1, new ListNode(0, new ListNode(1)));
        assertEquals(5, DecimalValueFromLinkedList.getDecimalValue(l));
    }

    @Test
    public void testTwo() {
        ListNode l = new ListNode(1, new ListNode(0, new ListNode(0)));
        assertEquals(4, DecimalValueFromLinkedList.getDecimalValue(l));
    }
}
