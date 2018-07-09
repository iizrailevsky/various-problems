package com.ilya.coding;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TreeAverageOfLevelsTest {

    @Test
    public void testErrors() {
        assertNull(TreeAverageOfLevels.averageOfLevels(null));
    }

    @Test
    public void testBasic() {
        TreeNode three = new TreeNode(3);
        TreeNode nine = new TreeNode(9);
        TreeNode twenty = new TreeNode(20);
        TreeNode fifteen = new TreeNode(15);
        TreeNode seven = new TreeNode(7);

        three.left = nine;
        three.right = twenty;
        twenty.left = fifteen;
        twenty.right = seven;

        List<Double> res = TreeAverageOfLevels.averageOfLevels(three);
        assertEquals(3.0, ((List) res).get(0));
        assertEquals(14.5, ((List) res).get(1));
        assertEquals(11.0, ((List) res).get(2));

    }
}
