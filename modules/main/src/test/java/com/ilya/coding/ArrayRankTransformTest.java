package com.ilya.coding;


import static org.junit.Assert.*;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class ArrayRankTransformTest {

    @Test
    public void testErrors() {
        assertEquals(null, ArrayRankTransform.arrayRankTransform(null));
        assertArrayEquals(new int[]{}, ArrayRankTransform.arrayRankTransform(new int[]{}));
    }

    @Test
    public void testBasic() {
        assertArrayEquals(new int[]{4, 1, 2, 3}, ArrayRankTransform.arrayRankTransform(new int[]{40, 10, 20, 30}));
        assertArrayEquals(new int[]{1, 1, 1}, ArrayRankTransform.arrayRankTransform(new int[]{100, 100, 100}));
        assertArrayEquals(new int[]{5,3,4,2,8,6,7,1,3}, ArrayRankTransform.arrayRankTransform(new int[]{37,12,28,9,100,56,80,5,12}));
    }
}
