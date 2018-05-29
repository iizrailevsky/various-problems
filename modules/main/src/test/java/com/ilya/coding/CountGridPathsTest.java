package com.ilya.coding;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class CountGridPathsTest {

    @Test
    public void testErrors() {
        assertEquals(-1, CountGridPaths.countPaths(null));
        assertEquals(-1, CountGridPaths.countPaths(new ArrayList<>(0)));
    }

    @Test
    public void testBasic() {
        List<String> grid = new ArrayList<>();
        grid.add("0000");
        grid.add("0100");
        grid.add("0000");
        assertEquals(4, CountGridPaths.countPaths(grid));
    }

    @Test
    public void testBasic1() {
        List<String> grid = new ArrayList<>();
        grid.add("0010");
        grid.add("0100");
        grid.add("0000");
        assertEquals(2, CountGridPaths.countPaths(grid));
    }
}
