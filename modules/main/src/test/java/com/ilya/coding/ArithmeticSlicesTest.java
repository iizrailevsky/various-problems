package com.ilya.coding;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArithmeticSlicesTest {

    @Test
    public void testErrors() {
        assertEquals(0, ArithmeticSlices.numberOfArithmeticSlices(null));
        assertEquals(0, ArithmeticSlices.numberOfArithmeticSlices(new int[] {}));
    }

    @Test
    public void testBasic() {
        assertEquals(7, ArithmeticSlices.numberOfArithmeticSlices(new int[] {2, 4, 6, 8, 10}));
    }
}
