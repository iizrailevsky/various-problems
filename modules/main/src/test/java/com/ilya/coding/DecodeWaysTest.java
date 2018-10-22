package com.ilya.coding;

import org.junit.Test;

import static org.junit.Assert.*;

public class DecodeWaysTest {

    @Test
    public void testErrors() {
        assertEquals(0, DecodeWays.numDecodings(""));
    }

    @Test
    public void testBasic() {
        assertEquals(1, DecodeWays.numDecodings("206"));
        assertEquals(3, DecodeWays.numDecodings("226"));
    }
}
