package com.ilya.coding;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import java.util.Arrays;

public class SerializeTreeTest {

    @Test
    public void testErrors() {
        assertNull(SerializeTree.serializeTree(null));
    }

    @Test
    public void testBasic() {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node eight = new Node(8);
        Node nine = new Node(9);

        one.setLeftChild(two);
        one.setRightChild(eight);
        two.setLeftChild(three);
        two.setRightChild(five);
        three.setRightChild(four);
        eight.setLeftChild(nine);

        int[] a = SerializeTree.serializeTree(one);
        System.out.println(a.length);
        System.out.println(Arrays.toString(a));
        assertEquals(15, a.length);

        Node root = SerializeTree.deserializeTree(a);
        System.out.println(Arrays.toString(SerializeTree.serializeTree(root)));
    }

}
