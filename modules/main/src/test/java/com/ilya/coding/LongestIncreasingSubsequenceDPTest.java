package com.ilya.coding;

import org.junit.Test;

import static org.junit.Assert.*;

public class LongestIncreasingSubsequenceDPTest {

    @Test
    public void testErrors() {
        assertEquals(-1, LongestIncreasingSubsequenceDP.longestIncreasingSubsequence(new int[] {}));
        assertEquals(-1, LongestIncreasingSubsequenceDP.longestIncreasingSubsequenceDP(new int[] {}));
    }

    @Test
    public void testBasic() {
        // recursive
        assertEquals(3, LongestIncreasingSubsequenceDP.longestIncreasingSubsequence(new int[] {3, 10, 2, 1, 20}));
        System.out.println(5 + " " + LongestIncreasingSubsequenceDP.countCalls);
        assertEquals(4, LongestIncreasingSubsequenceDP.longestIncreasingSubsequence(new int[] {3, 10, 2, 1, 20, 21}));
        System.out.println(6 + " " + LongestIncreasingSubsequenceDP.countCalls);
        assertEquals(4, LongestIncreasingSubsequenceDP.longestIncreasingSubsequence(new int[] {5, 10, 3, 2, 15, 20, 16}));
        System.out.println(7 + " " + LongestIncreasingSubsequenceDP.countCalls);
        assertEquals(5, LongestIncreasingSubsequenceDP.longestIncreasingSubsequence(new int[] {5, 10, 3, 2, 15, 20, 16, 23}));
        System.out.println(8 + " " + LongestIncreasingSubsequenceDP.countCalls);

        // dp - iterative
        assertEquals(3, LongestIncreasingSubsequenceDP.longestIncreasingSubsequenceDP(new int[] {3, 10, 2, 1, 20}));
        assertEquals(4, LongestIncreasingSubsequenceDP.longestIncreasingSubsequenceDP(new int[] {3, 10, 2, 1, 20, 21}));
        assertEquals(4, LongestIncreasingSubsequenceDP.longestIncreasingSubsequenceDP(new int[] {5, 10, 3, 2, 15, 20, 16}));
        assertEquals(5, LongestIncreasingSubsequenceDP.longestIncreasingSubsequenceDP(new int[] {5, 10, 3, 2, 15, 20, 16, 23}));
    }
}
