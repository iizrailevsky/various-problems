package com.ilya.coding;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNull;

public class MarathonRunnersTest {

    @Test
    public void testErrors() {
        assertNull(MarathonRunners.orderRunners(new int[] {}));
    }

    @Test
    public void testBasic() {
        assertArrayEquals(new int[] {3, 1, 0, 2}, MarathonRunners.orderRunners(new int[] {1, 3, 0, -1}));
    }
}
