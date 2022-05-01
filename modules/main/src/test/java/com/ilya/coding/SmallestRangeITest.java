package com.ilya.coding;

import org.junit.Test;

import static org.junit.Assert.*;

public class SmallestRangeITest {

    @Test
    public void testErrors() {
        assertEquals(-1, SmallestRangeI.smallestRangeI(null, 1));
        assertEquals(-1, SmallestRangeI.smallestRangeI(new int[]{1, 2}, -1));
    }

    @Test
    public void testBasic() {
        assertEquals(5, SmallestRangeI.smallestRangeI(new int[]{7, 0, 3, 5, 11, 13, 3}, 4));
        assertEquals(0, SmallestRangeI.smallestRangeI(new int[]{1}, 0));
        assertEquals(6, SmallestRangeI.smallestRangeI(new int[]{0, 10}, 2));
        assertEquals(0, SmallestRangeI.smallestRangeI(new int[]{1, 3, 6}, 3));
        assertEquals(0, SmallestRangeI.smallestRangeI(new int[]{5, 6, 4}, 5));
        assertEquals(6489, SmallestRangeI.smallestRangeI(new int[]{4103,2214,5569,6335,4244,9485,7545,8323,7841,8858}, 391));
        assertEquals(1, SmallestRangeI.smallestRangeI(new int[]{10, 14, 13, 15, 11, 19, 18}, 4));
        assertEquals(0, SmallestRangeI.smallestRangeI(new int[]{10, 14, 13, 15, 11, 19, 18}, 5));
        assertEquals(0, SmallestRangeI.smallestRangeI(new int[]{10, 14, 13, 15, 11, 19, 18}, 50));
    }
}
