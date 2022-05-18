package com.ilya.coding;

import org.junit.Test;
import static org.junit.Assert.*;

public class CountUniqueBinarySearchTreesTest {
    @Test
    public void testErrors() {
        assertEquals(1, CountUniqueBinarySearchTrees.numTrees(0));
        assertEquals(1, CountUniqueBinarySearchTrees.numTrees(1));
    }

    @Test
    public void testBasic() {
        assertEquals(2, CountUniqueBinarySearchTrees.numTrees(2));
        assertEquals(5, CountUniqueBinarySearchTrees.numTrees(3));
    }
}
