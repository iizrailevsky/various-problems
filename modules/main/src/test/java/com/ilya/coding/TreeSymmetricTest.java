package com.ilya.coding;

import org.junit.Test;

import static org.junit.Assert.*;

public class TreeSymmetricTest {

    @Test
    public void testErrors() {
        assertEquals(true, TreeSymmetric.isSymmetric(new TreeNode(1)));
    }

    @Test
    public void testBasic() {
        TreeNode one = new TreeNode(1);
        TreeNode two1 = new TreeNode(2);
        TreeNode two2 = new TreeNode(2);
        TreeNode three1 = new TreeNode(3);
        TreeNode three2 = new TreeNode(3);
        TreeNode four1 = new TreeNode(4);
        TreeNode four2 = new TreeNode(4);
        one.left = two1;
        one.right = two2;
        two1.left = three1;
        two1.right = four1;
        two2.left = four2;
        two2.right = three2;

        assertEquals(true, TreeSymmetric.isSymmetric(one));
    }

    @Test
    public void testBasic1() {
        TreeNode one = new TreeNode(1);
        TreeNode two1 = new TreeNode(2);
        TreeNode two2 = new TreeNode(2);
        TreeNode three1 = new TreeNode(3);
        TreeNode three2 = new TreeNode(3);

        one.left = two1;
        one.right = two2;
        two1.right = three1;
        two2.right = three2;

        assertEquals(false, TreeSymmetric.isSymmetric(one));
    }
}
