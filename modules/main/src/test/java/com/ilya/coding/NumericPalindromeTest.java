package com.ilya.coding;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class NumericPalindromeTest {

    @Test
    public void testErrors() {
        assertFalse(NumericPalindrome.isNumericPalindrome(-1L));
    }

    @Test
    public void testBasic() {
        assertTrue(NumericPalindrome.isNumericPalindrome(1L));
        assertFalse(NumericPalindrome.isNumericPalindrome(42L));
        assertTrue(NumericPalindrome.isNumericPalindrome(100001L));
        assertTrue(NumericPalindrome.isNumericPalindrome(999L));
        assertFalse(NumericPalindrome.isNumericPalindrome(123L));
    }
}
