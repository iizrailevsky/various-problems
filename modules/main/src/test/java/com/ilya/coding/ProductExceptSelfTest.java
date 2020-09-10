package com.ilya.coding;

import org.junit.Test;

import static org.junit.Assert.*;

public class ProductExceptSelfTest {

    @Test
    public void testErrors() {
        assertNull(ProductExceptSelf.productExceptSelf(null));
        assertNull(ProductExceptSelf.productExceptSelf(new int[] {}));
        assertNull(ProductExceptSelf.productExceptSelf(new int[] {0}));
    }

    @Test
    public void testCaseOne() {
        assertArrayEquals(new int[] {24, 12, 8, 6}, ProductExceptSelf.productExceptSelf(new int[] {1, 2, 3, 4}));
    }
}
