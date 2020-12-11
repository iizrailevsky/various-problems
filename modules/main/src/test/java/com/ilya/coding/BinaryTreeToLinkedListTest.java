package com.ilya.coding;

import static org.junit.Assert.*;

import org.junit.Test;

public class BinaryTreeToLinkedListTest {
    @Test
    public void testTree() {
        TreeNode one = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)),
                new TreeNode(5, null, new TreeNode(6)));
        BinaryTreeToLinkedList.flatten(one);
        assertNotNull(one);

    }
}
