package com.ilya.coding;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class LongestPalindromeTest {

    @Test
    public void testErrors() {
        assertNull(LongestPalindrome.longestPalindrome(null));
        assertEquals("", LongestPalindrome.longestPalindrome(""));
    }

    @Test
    public void testBasic() {
        assertEquals("bab", LongestPalindrome.longestPalindrome("babad"));
        assertEquals("bb", LongestPalindrome.longestPalindrome("cbbd"));
        assertEquals("b", LongestPalindrome.longestPalindrome("b"));
    }

    @Test
    public void testErrorsDP() {
        assertNull(LongestPalindrome.longestPalindromeDP(null));
        assertEquals("", LongestPalindrome.longestPalindromeDP(""));
    }

    @Test
    public void testBasicDP() {
        assertEquals("bab", LongestPalindrome.longestPalindromeDP("babad"));
        assertEquals("bb", LongestPalindrome.longestPalindromeDP("cbbd"));
        assertEquals("b", LongestPalindrome.longestPalindromeDP("b"));
    }
}
