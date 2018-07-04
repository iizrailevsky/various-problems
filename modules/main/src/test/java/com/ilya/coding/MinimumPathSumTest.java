package com.ilya.coding;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class MinimumPathSumTest {

    @Test
    public void testErrors() {
        assertEquals(0, MinimumPathSum.minPathSum(null));
        assertEquals(0, MinimumPathSum.minPathSum(new int[][]{}));
    }

    @Test
    public void testBasic() {
        assertEquals(7, MinimumPathSum.minPathSum(new int[][]{{1,3,1},{1,5,1},{4,2,1}}));
    }
}
