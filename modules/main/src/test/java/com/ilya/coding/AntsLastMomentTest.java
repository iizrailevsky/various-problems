package com.ilya.coding;

import static org.junit.Assert.*;

import org.junit.Test;

public class AntsLastMomentTest {

    @Test
    public void testCases() {
        assertEquals(4, AntsLastMoment.getLastMoment(4, new int[] {4, 3}, new int[] {0, 1}));
        assertEquals(7, AntsLastMoment.getLastMoment(7, new int[] {}, new int[] {0, 1, 2, 3, 4, 5, 6, 7}));
        assertEquals(7, AntsLastMoment.getLastMoment(7, new int[] {0, 1, 2, 3, 4, 5, 6, 7}, new int[] {}));
        assertEquals(5, AntsLastMoment.getLastMoment(9, new int[] {5}, new int[] {4}));
        assertEquals(6, AntsLastMoment.getLastMoment(6, new int[] {6}, new int[] {0}));
    }
}
