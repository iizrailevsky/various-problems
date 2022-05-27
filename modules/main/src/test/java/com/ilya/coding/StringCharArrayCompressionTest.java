package com.ilya.coding;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringCharArrayCompressionTest {

    @Test
    public void testErrors() {
        assertEquals(0, StringCharArrayCompression.compress(null));
        char[] input = new char[] {'a'};
        assertEquals(1, StringCharArrayCompression.compress(input));
        assertArrayEquals(new char[] {'a'}, input);
    }

    @Test
    public void testBasic() {
        char[] input = new char[] {'a','a','b','b','c','c','c'};
        assertEquals(6, StringCharArrayCompression.compress(input));
        assertArrayEquals(new char[] {'a','2','b','2','c','3', '\0'}, input);
    }

    @Test
    public void testAdvanced() {
        char[] input = new char[] {'a','b','b','b','b','b','b','b','b','b','b','b','b'};
        assertEquals(4, StringCharArrayCompression.compress(input));
        assertArrayEquals(new char[] {'a','b','1','2','\0','\0','\0','\0','\0','\0','\0','\0','\0'}, input);
    }
}
