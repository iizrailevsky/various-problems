package com.ilya.coding;

import static org.junit.Assert.*;

import org.junit.Test;

public class PermuteUniqueNumbersTest {

    @Test
    public void testErrors() {
        assertNull(PermuteUniqueNumbers.permuteUnique(null));
        assertEquals(0, PermuteUniqueNumbers.permuteUnique(new int[] {}).size());
    }

    @Test
    public void testBasic() {
        assertEquals(24, PermuteUniqueNumbers.permuteUnique(new int[] {1, 2, 3, 4}).size());
        assertEquals(120, PermuteUniqueNumbers.permuteUnique(new int[] {1, 2, 3, 4, 5}).size());
    }
}
