package com.ilya.coding;

import static org.junit.Assert.*;

import org.junit.Test;

public class BalancedStringTest {

    @Test
    public void testErrors() {
        assertEquals(0, BalancedString.balancedStringSplit(null));
        assertEquals(0, BalancedString.balancedStringSplit(""));
    }

    @Test
    public void testBasic() {

        assertEquals(4, BalancedString.balancedStringSplit("RLRRLLRLRL"));
        assertEquals(3, BalancedString.balancedStringSplit("RLLLLRRRLR"));
        assertEquals(1, BalancedString.balancedStringSplit("LLLLRRRR"));
    }
}
