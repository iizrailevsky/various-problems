package com.ilya.coding;

import org.junit.Test;

import static org.junit.Assert.*;

public class GridRegionsTest {

    @Test
    public void testErrors() {
        assertEquals(0, GridRegions.getSizeOfBiggestRegion(null, 0, 0));
        assertEquals(0, GridRegions.getSizeOfBiggestRegion(new int[][]{}, 1, 2));
    }

    @Test
    public void testBasic1() {
        int[][] grid1 = new int[][]{ {1, 1, 0, 0} , {0, 1, 1, 0}, {0, 0, 1, 0}, {1, 0, 0, 0}};
        assertEquals(5, GridRegions.getSizeOfBiggestRegion(grid1, 4, 4));
    }

    @Test
    public void testBasic2() {
        int[][] grid1 = new int[][]{ {0, 0, 1, 1} , {0, 0, 1, 0}, {0, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
        assertEquals(8, GridRegions.getSizeOfBiggestRegion(grid1, 5, 4));
    }
}
