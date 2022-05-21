package com.ilya.coding;

import org.junit.Test;

import static org.junit.Assert.*;

public class LowestCommonAncestorOfDeepestLeavesTest {

    @Test
    public void testErrors() {
        TreeNode one = new TreeNode(1);
        assertEquals(one, LowestCommonAncestorOfDeepestLeaves.lcaDeepestLeaves(one));
    }

    @Test
    public void testBasic() {
        TreeNode zero = new TreeNode(0);
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);

        zero.left = one;
        zero.right = three;
        one.right = two;

        assertEquals(two, LowestCommonAncestorOfDeepestLeaves.lcaDeepestLeaves(zero));
    }

    @Test
    public void testAdv() {
        TreeNode zero = new TreeNode(0);
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        TreeNode seven = new TreeNode(7);
        TreeNode eight = new TreeNode(8);

        three.left = five;
        three.right = one;
        five.left = six;
        five.right = two;
        two.left = seven;
        two.right = four;
        one.left = zero;
        one.right = eight;

        assertEquals(two, LowestCommonAncestorOfDeepestLeaves.lcaDeepestLeaves(three));
    }
}
