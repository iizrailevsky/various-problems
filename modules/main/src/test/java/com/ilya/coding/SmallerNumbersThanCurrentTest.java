package com.ilya.coding;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class SmallerNumbersThanCurrentTest {

    @Test
    public void testErrors() {
        assertEquals(null, SmallerNumbersThanCurrent.smallerNumbersThanCurrent(null));
        assertArrayEquals(new int[]{}, SmallerNumbersThanCurrent.smallerNumbersThanCurrent(new int[]{}));
    }

    @Test
    public void testBasic() {
        assertArrayEquals(new int[]{4,0,1,1,3}, SmallerNumbersThanCurrent.smallerNumbersThanCurrent(new int[]{8,1,2,2,3}));
        assertArrayEquals(new int[]{2,1,0,3}, SmallerNumbersThanCurrent.smallerNumbersThanCurrent(new int[]{6,5,4,8}));
        assertArrayEquals(new int[]{0,0,0,0}, SmallerNumbersThanCurrent.smallerNumbersThanCurrent(new int[]{7,7,7,7}));
    }
}
