package com.ilya.coding;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class ReductionOperationsTest {

    @Test
    public void testErrors() {
        assertEquals(-1, ReductionOperations.reductionOperations(null));
        assertEquals(-1, ReductionOperations.reductionOperations(new int[]{}));
    }

    @Test
    public void testBasic() {
        assertEquals(3, ReductionOperations.reductionOperations((new int[]{5, 1, 3})));
        assertEquals(0, ReductionOperations.reductionOperations((new int[]{1, 1, 1})));
        assertEquals(4, ReductionOperations.reductionOperations((new int[]{1,1,2,2,3})));
    }
}
