package com.ilya.coding;

import org.junit.Test;

import static org.junit.Assert.*;

public class PerfectSquaresLeastNumberTest {
    @Test
    public void testErrors() {
        assertEquals(-1 , PerfectSquaresLeastNumber.numSquares(-1));
    }

    @Test
    public void testBasic() {
        assertEquals(3, PerfectSquaresLeastNumber.numSquares(12));
        assertEquals(2, PerfectSquaresLeastNumber.numSquares(13));
        assertEquals(3, PerfectSquaresLeastNumber.numSquares(14));
        assertEquals(3, PerfectSquaresLeastNumber.numSquares(3));
        assertEquals(2, PerfectSquaresLeastNumber.numSquares(2));
        assertEquals(1, PerfectSquaresLeastNumber.numSquares(1));
        assertEquals(1, PerfectSquaresLeastNumber.numSquares(100));
        assertEquals(2, PerfectSquaresLeastNumber.numSquares(101));
    }
}
