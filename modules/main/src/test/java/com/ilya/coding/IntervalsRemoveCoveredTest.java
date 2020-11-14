package com.ilya.coding;

import org.junit.Test;

import static org.junit.Assert.*;

public class IntervalsRemoveCoveredTest {
    @Test
    public void testCases() {
        assertEquals(2, IntervalsRemoveCovered.removeCoveredIntervals(
                new int[][] {new int[] {1, 4}, new int[] {3, 6}, new int[] {2, 8} }));
        assertEquals(1, IntervalsRemoveCovered.removeCoveredIntervals(
                new int[][] {new int[] {1, 4}, new int[] {2, 3} }));
        assertEquals(2, IntervalsRemoveCovered.removeCoveredIntervals(
                new int[][] {new int[] {0, 10}, new int[] {5, 12} }));
        assertEquals(2, IntervalsRemoveCovered.removeCoveredIntervals(
                new int[][] {new int[] {3, 10}, new int[] {4, 10}, new int[] {5, 11} }));
        assertEquals(1, IntervalsRemoveCovered.removeCoveredIntervals(
                new int[][] {new int[] {1, 2}, new int[] {1, 4}, new int[] {3, 4} }));
    }
}
