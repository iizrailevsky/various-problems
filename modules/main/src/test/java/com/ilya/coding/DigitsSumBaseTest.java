package com.ilya.coding;

import org.junit.Test;

import static org.junit.Assert.*;

public class DigitsSumBaseTest {

    @Test
    public void testErrors() {
        assertEquals(-1, DigitsSumBase.sumBaseSlow(0, 6));
        assertEquals(-1, DigitsSumBase.sumBaseSlow(0, 11));

        assertEquals(-1, DigitsSumBase.sumBase(0, 6));
        assertEquals(-1, DigitsSumBase.sumBase(0, 11));
    }

    @Test
    public void testBasic() {
        assertEquals(9, DigitsSumBase.sumBaseSlow(34, 6));
        assertEquals(1, DigitsSumBase.sumBaseSlow(10, 10));

        assertEquals(9, DigitsSumBase.sumBase(34, 6));
        assertEquals(1, DigitsSumBase.sumBase(10, 10));
    }
}
