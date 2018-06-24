package com.ilya.coding;

import static org.junit.Assert.*;

import org.junit.Test;

public class ChooseKFromNTest {

    @Test
    public void testErrors() {
        assertEquals(null, ChooseKFromN.chooseKFromN(null, -1));
        assertEquals(null, ChooseKFromN.chooseKFromN(new int[] {}, 1));
    }

    @Test
    public void testBasic() {
        assertEquals(10, ChooseKFromN.chooseKFromN(new int[] {1, 2, 3, 4, 5}, 3).size());
        assertEquals(20, ChooseKFromN.chooseKFromN(new int[] {1, 2, 3, 4, 5, 6}, 3).size());
    }
}
