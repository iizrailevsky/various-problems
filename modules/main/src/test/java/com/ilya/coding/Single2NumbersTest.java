package com.ilya.coding;

import org.junit.Test;

import static org.junit.Assert.*;

public class Single2NumbersTest {

    @Test
    public void testErrors() {
        assertNull(Single2Numbers.getTwoSingleNumbers(new int[] {0}));
    }

    @Test
    public void testBasic() {
        assertArrayEquals(new int[] {5, 3}, Single2Numbers.getTwoSingleNumbers(new int[] {1, 2, 1, 3, 2, 5}));
    }
}
