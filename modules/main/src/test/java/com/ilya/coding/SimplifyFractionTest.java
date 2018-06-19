package com.ilya.coding;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SimplifyFractionTest {

    @Test(expected = IllegalArgumentException.class)
    public void testErrors() {
        SimplifyFraction.simplify_fraction(0, 0, null);
    }

    @Test
    public void testBasic1() {
        int[] result = new int[2];
        SimplifyFraction.simplify_fraction(77, 22, result);
        assertEquals(7, result[0]);
        assertEquals(2, result[1]);
    }

    @Test
    public void testBasic2() {
        int[] result = new int[2];
        SimplifyFraction.simplify_fraction(100, 50, result);
        assertEquals(2, result[0]);
        assertEquals(1, result[1]);
    }

    @Test
    public void testBasic3() {
        int[] result = new int[2];
        SimplifyFraction.simplify_fraction(3, 6, result);
        assertEquals(1, result[0]);
        assertEquals(2, result[1]);
    }
}
