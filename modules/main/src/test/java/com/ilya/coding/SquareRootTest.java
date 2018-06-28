package com.ilya.coding;

import org.junit.Test;

import static org.junit.Assert.*;

public class SquareRootTest {

    @Test
    public void testErrors() {
        assertEquals(-1, SquareRoot.sqrt(-1));
        assertEquals(0, SquareRoot.sqrt(0));
    }

    @Test
    public void testBasics() {
        assertEquals(2, SquareRoot.sqrt(4));
        assertEquals(2, SquareRoot.sqrt(8));
        assertEquals(3, SquareRoot.sqrt(10));
        assertEquals(9, SquareRoot.sqrt(99));
        assertEquals(10, SquareRoot.sqrt(100));
    }
}
