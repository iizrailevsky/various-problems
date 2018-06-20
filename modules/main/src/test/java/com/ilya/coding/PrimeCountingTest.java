package com.ilya.coding;

import java.util.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class PrimeCountingTest {

    @Test
    public void testErrors() {
        assertEquals(0, PrimeCounting.primeCounting(-1));
    }

    @Test
    public void testBasic() {
        assertEquals(4, PrimeCounting.primeCounting(10));
    }
}
