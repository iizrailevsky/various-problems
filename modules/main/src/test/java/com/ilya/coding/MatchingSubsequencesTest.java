package com.ilya.coding;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class MatchingSubsequencesTest {

    @Test (expected = IllegalArgumentException.class)
    public void testErrors() {
        MatchingSubsequences.numMatchingSubseq(null, null);
    }

    @Test
    public void testBasic() {
        assertEquals(3, MatchingSubsequences.numMatchingSubseq("abcde", new String[] {"a", "bb", "acd", "ace"}));
        assertEquals(4, MatchingSubsequences.numMatchingSubseq("aabcde", new String[] {"a", "bb", "acd", "ace", "aacde"}));
        assertEquals(2, MatchingSubsequences.numMatchingSubseq("dsahjpjauf", new String[] {"ahjpjau", "ja", "ahbwzgqnuk", "tnmlanowax"}));
    }
}
