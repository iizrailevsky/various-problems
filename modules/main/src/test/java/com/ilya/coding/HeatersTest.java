package com.ilya.coding;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.*;

public class HeatersTest {

    @Test
    public void testErrors() {
        assertEquals(-1, Heaters.findRadius(null, null));
    }

    @Test
    public void testBasic() {
        assertEquals(1, Heaters.findRadius(new int[] {1, 2, 3}, new int[] {2}));
        assertEquals(2, Heaters.findRadius(new int[] {1, 2, 3}, new int[] {1}));
        assertEquals(2, Heaters.findRadius(new int[] {1, 2, 3}, new int[] {3}));
        assertEquals(1, Heaters.findRadius(new int[] {1, 2, 3, 4}, new int[] {1, 4}));
        assertEquals(3, Heaters.findRadius(new int[] {1, 2, 3, 4}, new int[] {1}));
        assertEquals(3, Heaters.findRadius(new int[] {1, 5}, new int[] {2}));
    }
}
