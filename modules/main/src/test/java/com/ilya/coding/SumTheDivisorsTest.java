package com.ilya.coding;

import org.junit.Test;

import static org.junit.Assert.*;

public class SumTheDivisorsTest {

    @Test
    public void testErrors() {
        assertEquals(-1, SumTheDivisors.sumTheDivisors(-1));
    }

    @Test
    public void testBasic() {
        assertEquals(15, SumTheDivisors.sumTheDivisors(8));
        assertEquals(8, SumTheDivisors.sumTheDivisors(7));
        assertEquals(1, SumTheDivisors.sumTheDivisors(1));
        assertEquals(2340, SumTheDivisors.sumTheDivisors(1000));
    }
}
