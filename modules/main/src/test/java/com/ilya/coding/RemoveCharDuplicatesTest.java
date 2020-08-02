package com.ilya.coding;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class RemoveCharDuplicatesTest {

    @Test
    public void testNull() {
        char[] a = null;
        RemoveCharDuplicates.removeCharDuplicates(null);
        assertNull(a);
    }

    @Test
    public void testEmpty() {
        char[] a = "".toCharArray();
        RemoveCharDuplicates.removeCharDuplicates(a);
        assertEquals(0, a.length);
    }

    @Test
    public void testAABB() {
        char[] a = "aabb".toCharArray();
        RemoveCharDuplicates.removeCharDuplicates(a);
        assertArrayEquals(new char[] {'a', 'b', 0, 'b'}, a);
    }

    @Test
    public void testABCD() {
        char[] a = "abcd".toCharArray();
        RemoveCharDuplicates.removeCharDuplicates(a);
        System.out.println(a);
        assertArrayEquals(new char[] {'a', 'b', 'c', 'd'}, a);
    }

    @Test
    public void testAAA() {
        char[] a = "aaa".toCharArray();
        RemoveCharDuplicates.removeCharDuplicates(a);
        assertArrayEquals(new char[] {'a', 0, 'a'}, a);
    }
}
