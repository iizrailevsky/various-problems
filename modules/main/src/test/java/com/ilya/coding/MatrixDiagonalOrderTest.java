package com.ilya.coding;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import java.util.*;

public class MatrixDiagonalOrderTest {
    @Test
    public void testError() {
        assertArrayEquals(new int[] {}, MatrixDiagonalOrder.findDiagonalOrder(null));
        assertArrayEquals(new int[] {}, MatrixDiagonalOrder.findDiagonalOrder(new ArrayList<>()));
    }

    @Test
    public void testOne() {
        List<List<Integer>> in = new ArrayList<>();
        in.add(Arrays.asList(1,2,3));
        in.add(Arrays.asList(4,5,6));
        in.add(Arrays.asList(7,8,9));

        assertArrayEquals(new int[] {1,4,2,7,5,3,8,6,9}, MatrixDiagonalOrder.findDiagonalOrder(in));
    }

    @Test
    public void testTwo() {
        List<List<Integer>> in = new ArrayList<>();
        in.add(Arrays.asList(1,2,3,4,5));
        in.add(Arrays.asList(6,7));
        in.add(Arrays.asList(8));
        in.add(Arrays.asList(9,10,11));
        in.add(Arrays.asList(12,13,14,15,16));

        assertArrayEquals(new int[] {1,6,2,8,7,3,9,4,12,10,5,13,11,14,15,16}, MatrixDiagonalOrder.findDiagonalOrder(in));
    }

    @Test
    public void testThree() {
        // [[],[],[],[],[]]
        List<List<Integer>> in = new ArrayList<>();
        in.add(Arrays.asList(1,2,3));
        in.add(Arrays.asList(4));
        in.add(Arrays.asList(5,6,7));
        in.add(Arrays.asList(8));
        in.add(Arrays.asList(9,10,11));

        assertArrayEquals(new int[] {1,4,2,5,3,8,6,9,7,10,11}, MatrixDiagonalOrder.findDiagonalOrder(in));
    }

    @Test
    public void testFour() {
        List<List<Integer>> in = new ArrayList<>();
        in.add(Arrays.asList(1,2,3,4,5,6));

        assertArrayEquals(new int[] {1,2,3,4,5,6}, MatrixDiagonalOrder.findDiagonalOrder(in));
    }
}
