package com.ilya.coding;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringCompressionTest {

    @Test
    public void testErrors() {
        assertEquals(null, StringCompression.compress(null));
        assertEquals("", StringCompression.compress(""));
    }

    @Test
    public void testBasic() {
        assertEquals("a2b1c5a3", StringCompression.compress("aabcccccaaa"));
        assertEquals("A2b3C3d4A3", StringCompression.compress("AAbbbCCCddddAAA"));
        assertEquals("a2", StringCompression.compress("aa"));
        assertEquals("a2", StringCompression.compress("aa"));
        assertEquals("a", StringCompression.compress("a"));
    }
}
