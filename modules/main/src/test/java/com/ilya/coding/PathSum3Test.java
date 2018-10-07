package com.ilya.coding;

import org.junit.Test;

import static org.junit.Assert.*;

public class PathSum3Test {

    @Test
    public void testErrors() {
        assertEquals(0, PathSum3.pathSum(null, 0));
    }

    @Test
    public void testBasic() {
        TreeNode ten = new TreeNode(10);
        TreeNode five = new TreeNode(5);
        TreeNode negThree = new TreeNode(-3);
        TreeNode three = new TreeNode(3);
        TreeNode two = new TreeNode(2);
        TreeNode eleven = new TreeNode(11);
        TreeNode three2 = new TreeNode(3);
        TreeNode negTwo = new TreeNode(-2);
        TreeNode one = new TreeNode(1);

        ten.left = five;
        ten.right = negThree;
        five.left = three;
        five.right = two;
        three.left = three2;
        three.right = negTwo;
        two.right = one;
        negThree.right = eleven;

        assertEquals(3, PathSum3.pathSum(ten, 8));
        assertEquals(2, PathSum3.pathSum(ten, 1));
    }
}
