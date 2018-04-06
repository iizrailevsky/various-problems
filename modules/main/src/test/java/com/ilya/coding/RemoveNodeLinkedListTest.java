package com.ilya.coding;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNull;

import org.junit.Test;

/**
 * Created by iizrailevsky on 4/6/18.
 */
public class RemoveNodeLinkedListTest {

    @Test
    public void testNullRoot() {
        LinkedListNode<Integer> ret = RemoveNodeLinkedList.removeNodesWithValue(null, 1);
        assertNull(ret);
    }

    @Test
    public void testOneWithValue() {
        LinkedListNode<Integer> llist = new LinkedListNode<>(1);
        LinkedListNode<Integer> ret = RemoveNodeLinkedList.removeNodesWithValue(llist, 1);
        assertNull(ret);
    }

    @Test
    public void testThreeNoValue() {
        LinkedListNode<Integer> llist = new LinkedListNode<>(1);
        LinkedListNode<Integer> two = new LinkedListNode<>(2);
        LinkedListNode<Integer> three = new LinkedListNode<>(3);
        llist.setNext(two);
        two.setNext(three);
        llist.dumpLinkedList();

        LinkedListNode<Integer> ret = RemoveNodeLinkedList.removeNodesWithValue(llist, 4);
        ret.dumpLinkedList();
        assertEquals(3, ret.size());
    }

    @Test
    public void testThreeWithValue() {
        LinkedListNode<Integer> llist = new LinkedListNode<>(1);
        LinkedListNode<Integer> two = new LinkedListNode<>(2);
        LinkedListNode<Integer> three = new LinkedListNode<>(3);
        llist.setNext(two);
        two.setNext(three);
        llist.dumpLinkedList();

        LinkedListNode<Integer> ret = RemoveNodeLinkedList.removeNodesWithValue(llist, 3);
        ret.dumpLinkedList();
        assertEquals(2, ret.size());
    }

    @Test
    public void testThreeWithValueMidValue() {
        LinkedListNode<Integer> llist = new LinkedListNode<>(1);
        LinkedListNode<Integer> two = new LinkedListNode<>(2);
        LinkedListNode<Integer> three = new LinkedListNode<>(3);
        llist.setNext(two);
        two.setNext(three);
        llist.dumpLinkedList();

        LinkedListNode<Integer> ret = RemoveNodeLinkedList.removeNodesWithValue(llist, 2);
        ret.dumpLinkedList();
        assertEquals(2, ret.size());
    }

    @Test
    public void testThreeWithValueCornerValue() {
        LinkedListNode<Integer> llist = new LinkedListNode<>(3);
        LinkedListNode<Integer> two = new LinkedListNode<>(2);
        LinkedListNode<Integer> three = new LinkedListNode<>(3);
        llist.setNext(two);
        two.setNext(three);
        llist.dumpLinkedList();

        LinkedListNode<Integer> ret = RemoveNodeLinkedList.removeNodesWithValue(llist, 3);
        ret.dumpLinkedList();
        assertEquals(1, ret.size());
    }

    @Test
    public void testAllThreeWithValue() {
        LinkedListNode<Integer> llist = new LinkedListNode<>(3);
        LinkedListNode<Integer> two = new LinkedListNode<>(3);
        LinkedListNode<Integer> three = new LinkedListNode<>(3);
        llist.setNext(two);
        two.setNext(three);
        llist.dumpLinkedList();

        LinkedListNode<Integer> ret = RemoveNodeLinkedList.removeNodesWithValue(llist, 3);
        assertNull(ret);
    }

}
