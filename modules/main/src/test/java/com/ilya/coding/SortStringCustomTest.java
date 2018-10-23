package com.ilya.coding;

import org.junit.Test;

import static org.junit.Assert.*;

public class SortStringCustomTest {

    @Test
    public void testErrors() {
        assertEquals(null, SortStringCustom.customSortString(null, null));
    }

    @Test
    public void testBasic() {
        assertEquals("dcba", SortStringCustom.customSortString("cba", "abcd"));
        assertEquals("dccba", SortStringCustom.customSortString("cba", "abcdc"));
    }
}
