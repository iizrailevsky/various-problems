package com.ilya.coding;

import static org.junit.Assert.*;

import org.junit.Test;

public class BinaryContiguousArrayTest {

    @Test
    public void testErrors() {
        assertEquals(0, BinaryContiguousArray.findMaxLength(new int[] {}));
    }

    @Test
    public void testBasic() {
        assertEquals(2, BinaryContiguousArray.findMaxLength(new int[] {0, 1}));
        assertEquals(2, BinaryContiguousArray.findMaxLength(new int[] {0, 1, 0}));
        assertEquals(6, BinaryContiguousArray.findMaxLength(new int[] {0, 0, 1, 0, 0, 1, 1}));
        assertEquals(6, BinaryContiguousArray.findMaxLength(new int[] {0, 0, 1, 0, 0, 0, 1, 1}));
    }
}
