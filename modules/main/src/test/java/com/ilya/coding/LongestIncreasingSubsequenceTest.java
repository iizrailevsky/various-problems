package com.ilya.coding;


import static org.junit.Assert.*;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import java.util.ArrayList;

public class LongestIncreasingSubsequenceTest {

    @Test
    public void testError() {
        assertEquals(0, LongestIncreasingSubsequence.getLongestIncreasingSubsequence(new ArrayList<>()).size());
    }
}

