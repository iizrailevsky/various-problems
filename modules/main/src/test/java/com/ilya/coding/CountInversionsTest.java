package com.ilya.coding;

import org.junit.Test;
import static org.junit.Assert.*;

public class CountInversionsTest {

    @Test
    public void testErrors() {
        assertEquals(0, CountInversions.countInversions(null, true));
        assertEquals(0, CountInversions.countInversions(null, false));
        assertEquals(0, CountInversions.countInversions(new int[0], true));
        assertEquals(0, CountInversions.countInversions(new int[0], false));
    }

    @Test
    public void testBasic() {
        assertEquals(2, CountInversions.countInversions(new int[] {2, 4, 1}, true));
        assertEquals(2, CountInversions.countInversions(new int[] {2, 4, 1}, false));
    }

    @Test
    public void testAdvanced() {
        assertEquals(0, CountInversions.countInversions(new int[] {1, 1, 1, 2, 2}, true));
        assertEquals(0, CountInversions.countInversions(new int[] {1, 1, 1, 2, 2}, false));
        assertEquals(4, CountInversions.countInversions(new int[] {2, 1, 3, 1, 2}, true));
        assertEquals(2, CountInversions.countInversions(new int[] {2, 1, 3, 1, 2}, false));
    }
}
