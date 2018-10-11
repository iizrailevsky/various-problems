package com.ilya.coding;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.*;

public class TriangleTest {

    @Test
    public void testErrors() {
        assertEquals(-1, Triangle.minimumTotal(null));
    }

    @Test
    public void testBasic() {
        List<List<Integer>> triange = new ArrayList();

        List<Integer> one = new ArrayList();
        one.add(2);
        triange.add(one);

        List<Integer> two = new ArrayList();
        two.add(3);
        two.add(4);
        triange.add(two);

        List<Integer> three = new ArrayList();
        three.add(6);
        three.add(5);
        three.add(7);
        triange.add(three);

        List<Integer> four = new ArrayList();
        four.add(4);
        four.add(1);
        four.add(8);
        four.add(3);
        triange.add(four);

        assertEquals(11, Triangle.minimumTotal(triange));
    }
}
