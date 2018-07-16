package com.ilya.coding;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.*;


public class SubarraysSummingToTargetTest {

    @Test
    public void testErrors() {
        assertNull(SubarraysSummingToTarget.findSubarraysSummingToTarget(new int[] {}, 3));
    }

    @Test
    public void testBasic() {
        List<List<Integer>> res = SubarraysSummingToTarget.findSubarraysSummingToTarget(new int[] {10, -20, 5, 12, -6, 1, 15, 5}, 7);
        for (List<Integer> pair : res) {
            System.out.println("[" + pair.get(0) + " " + pair.get(1) + "]");
        }
        assertEquals(0, res.get(0).get(0).intValue());
        assertEquals(3, res.get(0).get(1).intValue());
        assertEquals(3, res.get(1).get(0).intValue());
        assertEquals(5, res.get(1).get(1).intValue());
        assertEquals(1, res.get(2).get(0).intValue());
        assertEquals(6, res.get(2).get(1).intValue());
    }
}
