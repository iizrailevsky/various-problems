package com.ilya.coding;

import static org.junit.Assert.*;

import org.junit.Test;

public class BasicCalculator2Test {

    @Test(expected = IllegalArgumentException.class)
    public void testErrors() {
        BasicCalculator2.calculate(null);
    }

    @Test
    public void testBasic() {
        assertEquals(7, BasicCalculator2.calculate("3+2*2"));
        assertEquals(1, BasicCalculator2.calculate(" 3/2 "));
        assertEquals(5, BasicCalculator2.calculate(" 3+5 / 2 "));
        assertEquals(4, BasicCalculator2.calculate("2+2"));
        assertEquals(0, BasicCalculator2.calculate("0-0"));
    }
}
