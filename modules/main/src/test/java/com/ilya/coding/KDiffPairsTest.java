package com.ilya.coding;

import static org.junit.Assert.*;

import org.junit.Test;

public class KDiffPairsTest {

    @Test
    public void testEmpty() {
        assertEquals(0, KDiffPairs.findPairs(null, 0));
        assertEquals(0, KDiffPairs.findPairs(new int[] {}, 0));
        assertEquals(0, KDiffPairs.findPairs(new int[] {1}, -3));
    }

    @Test
    public void testOne() {
        assertEquals(2, KDiffPairs.findPairs(new int[] {3, 1, 4, 1, 5}, 2));
    }

    @Test
    public void testTwo() {
        assertEquals(4, KDiffPairs.findPairs(new int[] {1, 2, 3, 4, 5}, 1));
    }

    @Test
    public void testThree() {
        assertEquals(1, KDiffPairs.findPairs(new int[] {1, 3, 1, 5, 4}, 0));
    }

    @Test
    public void testFour() {
        assertEquals(1, KDiffPairs.findPairs(new int[] {1, 3, 1, 5, 1}, 0));
    }

    @Test
    public void testFive() {
        assertEquals(0, KDiffPairs.findPairs(new int[] {1, 3, 1, 5, 1}, 10));
    }
}

