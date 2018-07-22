package com.ilya.coding;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.*;

public class ModifiedPalindromeTest {

    @Test
    public void testErrors() {
        assertFalse(ModifiedPalindrome.isModifPalindrome(null, true));
    }

    @Test
    public void testBasic() {
        assertTrue(ModifiedPalindrome.isModifPalindrome("", true));
        assertTrue(ModifiedPalindrome.isModifPalindrome("a", true));
        assertTrue(ModifiedPalindrome.isModifPalindrome("aa", true));
        assertTrue(ModifiedPalindrome.isModifPalindrome("ab", true));
        assertTrue(ModifiedPalindrome.isModifPalindrome("racecar", true));
        assertTrue(ModifiedPalindrome.isModifPalindrome("facecar", true));
        assertTrue(ModifiedPalindrome.isModifPalindrome("bacadb", true));
        assertTrue(ModifiedPalindrome.isModifPalindrome("bdacab", true));
        assertFalse(ModifiedPalindrome.isModifPalindrome("abcde", true));
    }
}
