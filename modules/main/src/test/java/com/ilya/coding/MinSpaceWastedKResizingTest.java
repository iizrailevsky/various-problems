package com.ilya.coding;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class MinSpaceWastedKResizingTest {

    @Test
    public void testErrors() {
        assertEquals(-1, MinSpaceWastedKResizing.minSpaceWastedKResizing(null, -1));
        assertEquals(-1, MinSpaceWastedKResizing.minSpaceWastedKResizing(new int[]{}, 1));
    }

    @Test
    public void testBasic() {
        assertEquals(10, MinSpaceWastedKResizing.minSpaceWastedKResizing(new int[]{10, 20}, 0));
        assertEquals(10, MinSpaceWastedKResizing.minSpaceWastedKResizing(new int[]{10, 20, 30}, 1));
        assertEquals(15, MinSpaceWastedKResizing.minSpaceWastedKResizing(new int[]{10, 20, 15, 30, 20}, 2));
        assertEquals(136, MinSpaceWastedKResizing.minSpaceWastedKResizing(new int[]{38,28,3,2,6,14,15,33,39}, 1));
    }
}
