package com.ilya.coding;

import static org.junit.Assert.*;

import org.junit.Test;

public class AlmostPalindromeTest {

    @Test
    public void testCaseOne() {
        assertTrue(AlmostPalindrome.isAlmostPalindrome("aba"));
    }

    @Test
    public void testCaseTwo() {
        assertFalse(AlmostPalindrome.isAlmostPalindrome("abcabc"));
    }

    @Test
    public void testCaseThree() {
        assertTrue(AlmostPalindrome.isAlmostPalindrome("abcbca"));
    }
}
