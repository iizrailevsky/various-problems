package com.ilya.coding;

import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListComponentsTest {

    @Test
    public void testErrors() {
        assertEquals(0, LinkedListComponents.numComponents(null, null));
    }

    @Test
    public void testBasic() {
        ListNode node = new ListNode(0);
        int[] G = new int[] {0};
        assertEquals(1, LinkedListComponents.numComponents(node, G));
    }

    @Test
    public void testAdvanced1() {
        ListNode zero = new ListNode(0);
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        zero.next = one;
        one.next = two;
        two.next = three;
        int[] G = new int[] {0, 1, 3};
        assertEquals(2, LinkedListComponents.numComponents(zero, G));
    }

    @Test
    public void testAdvanced2() {
        ListNode zero = new ListNode(0);
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        zero.next = one;
        one.next = two;
        two.next = three;
        three.next = four;
        int[] G = new int[] {0, 3, 1, 4};
        assertEquals(2, LinkedListComponents.numComponents(zero, G));
    }
}
