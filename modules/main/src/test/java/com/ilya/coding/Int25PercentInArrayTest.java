package com.ilya.coding;

import org.junit.Test;

import static org.junit.Assert.*;

public class Int25PercentInArrayTest {

    @Test
    public void testError() {
        assertEquals(-1, Int25PercentInArray.findSpecialInteger(null));
        assertEquals(-1, Int25PercentInArray.findSpecialInteger(new int[] {}));
    }

    @Test
    public void testCase() {
        assertEquals(6, Int25PercentInArray.findSpecialInteger(new int[] {1,2,2,6,6,6,6,7,10}));
    }
}
