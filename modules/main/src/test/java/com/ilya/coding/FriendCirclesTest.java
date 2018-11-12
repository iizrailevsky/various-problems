package com.ilya.coding;

import org.junit.Test;

import static org.junit.Assert.*;


public class FriendCirclesTest {

    @Test
    public void testErrors() {
        assertEquals(-1, FriendCircles.findCircleNum(null));
    }

    @Test
    public void testBasic1() {
        int[][] M = new int[][] {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        assertEquals(2, FriendCircles.findCircleNum(M));
    }

    @Test
    public void testBasic2() {
        int[][] M = new int[][] {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
        assertEquals(1, FriendCircles.findCircleNum(M));
    }

    @Test
    public void testBasic3() {
        int[][] M = new int[][] {{1, 0, 0, 1}, {0, 1, 1, 0}, {0, 1, 1, 1}, {1, 0, 1, 1}};
        assertEquals(1, FriendCircles.findCircleNum(M));
    }
}
