package com.ilya.coding;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by iizrailevsky on 4/27/18.
 */
public class LengthOfLongestSubstringTest {
    private LengthOfLongestSubstring longest = new LengthOfLongestSubstring();

    @Test
    public void testErrorCases() {
        assertEquals(0, longest.lengthOfLongestSubstring(null));
        assertEquals(0, longest.lengthOfLongestSubstring(""));
        assertEquals(1, longest.lengthOfLongestSubstring("a"));
    }

    @Test
    public void testBasicCases() {
        assertEquals(3, longest.lengthOfLongestSubstring("abcabcbb"));
        assertEquals(1, longest.lengthOfLongestSubstring("bbbbb"));
        assertEquals(3, longest.lengthOfLongestSubstring("pwwkew"));
        assertEquals(2, longest.lengthOfLongestSubstring("au"));
    }

    @Test
    public void testAdvancedCases() {
        assertEquals(6, longest.lengthOfLongestSubstring("aaaz123a55"));
    }
}
