package com.ilya.coding;

import org.junit.Test;

import static org.junit.Assert.*;

public class PruneZeroSubtreesTest {
    @Test
    public void testErrors() {
        assertEquals(null, PruneZeroSubtrees.pruneTree(null));
    }

    @Test
    public void testOne() {
        TreeNode one1 = new TreeNode(1);
        TreeNode one2 = new TreeNode(1);
        TreeNode zero1 = new TreeNode(0);
        TreeNode zero2 = new TreeNode(0);
        one1.right = zero1;
        zero1.left = zero2;
        zero1.right = one2;

        assertEquals(one1, PruneZeroSubtrees.pruneTree(one1));
        assertEquals(null, zero1.left);
    }

    @Test
    public void testTwo() {
        TreeNode one1 = new TreeNode(1);
        TreeNode one2 = new TreeNode(1);
        TreeNode one3 = new TreeNode(1);
        TreeNode zero1 = new TreeNode(0);
        TreeNode zero2 = new TreeNode(0);
        TreeNode zero3 = new TreeNode(0);
        TreeNode zero4 = new TreeNode(0);
        one1.left = zero1;
        one1.right = one2;
        zero1.left = zero2;
        zero1.right = zero3;
        one1.left = zero4;
        one1.right = one3;

        assertEquals(one1, PruneZeroSubtrees.pruneTree(one1));
        assertEquals(null, one1.left);
        assertEquals(null, one2.left);
    }

    @Test
    public void testThree() {
        TreeNode zero1 = new TreeNode(0);
        TreeNode zero2 = new TreeNode(0);
        TreeNode zero3 = new TreeNode(0);
        TreeNode zero4 = new TreeNode(0);
        zero1.right = zero2;
        zero2.left = zero3;
        zero2.right = zero4;

        assertEquals(null, PruneZeroSubtrees.pruneTree(zero1));
    }

}
