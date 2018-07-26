package com.ilya.coding;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.*;

public class ModifiedPalindromeTest {

    @Test
    public void testErrors() {
        assertFalse(ModifiedPalindrome.isModifPalindrome(null));
    }

    @Test
    public void testBasic() {
        assertTrue(ModifiedPalindrome.isModifPalindrome(""));
        assertTrue(ModifiedPalindrome.isModifPalindrome("a"));
        assertTrue(ModifiedPalindrome.isModifPalindrome("aa"));
        assertTrue(ModifiedPalindrome.isModifPalindrome("ab"));
        assertTrue(ModifiedPalindrome.isModifPalindrome("racecar"));
        assertTrue(ModifiedPalindrome.isModifPalindrome("facecar"));
        assertTrue(ModifiedPalindrome.isModifPalindrome("bacadb"));
        assertTrue(ModifiedPalindrome.isModifPalindrome("bdacab"));
        assertFalse(ModifiedPalindrome.isModifPalindrome("abcde"));
    }
}
