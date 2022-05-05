package com.ilya.coding;

import org.junit.Test;

import static org.junit.Assert.*;

public class RomanToIntegerTest {

    @Test
    public void testErrors() {
        assertEquals(-1, RomanToInteger.romanToInt(null));
        assertEquals(-1, RomanToInteger.romanToInt(""));
    }

    @Test
    public void testBasic() {
        assertEquals(3, RomanToInteger.romanToInt("III"));
        assertEquals(58, RomanToInteger.romanToInt("LVIII"));
        assertEquals(1994, RomanToInteger.romanToInt("MCMXCIV"));
    }
}
