package com.ilya.coding;

import static org.junit.Assert.*;

import org.junit.Test;

public class ShortestCompletingWordTest {

    @Test
    public void testErrors() {
        assertNull(ShortestCompletingWord.shortestCompletingWord(null, null));
    }

    @Test
    public void testBasic() {
        assertEquals("steps", ShortestCompletingWord.shortestCompletingWord("1s3 PSt", new String[] {
                "step", "steps", "stripe", "stepple"
        }));
        assertEquals("pest", ShortestCompletingWord.shortestCompletingWord("1s3 456", new String[] {
                "looks", "pest", "stew", "show"
        }));
    }
}
