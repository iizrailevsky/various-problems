package com.ilya.coding;

import org.junit.Test;

import static org.junit.Assert.*;

public class TreeCousinsTest {
    @Test
    public void testEmpty() {
        assertFalse(TreeCousins.isCousins(null, 1, 2));
        assertFalse(TreeCousins.isCousins(new TreeNode(0, null, null), 0, 0));
    }

    @Test
    public void testOne() {
        TreeNode one = new TreeNode(1,
                new TreeNode(2, new TreeNode(4, null, null), null),
                new TreeNode(3, null, null)
        );

        assertFalse(TreeCousins.isCousins(one, 4, 3));
    }

    @Test
    public void testTwo() {
        TreeNode one = new TreeNode(1,
                new TreeNode(2, null, new TreeNode(4, null, null)),
                new TreeNode(3, null, new TreeNode(5, null, null))
        );

        assertTrue(TreeCousins.isCousins(one, 5, 4));
    }

    @Test
    public void testThree() {
        TreeNode one = new TreeNode(1,
                new TreeNode(2, null, new TreeNode(4, null, null)),
                new TreeNode(3, null, null)
        );

        assertFalse(TreeCousins.isCousins(one, 2, 3));
    }
}
