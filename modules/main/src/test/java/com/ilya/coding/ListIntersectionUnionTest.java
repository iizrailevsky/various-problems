package com.ilya.coding;

import java.util.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class ListIntersectionUnionTest {

    @Test
    public void testEmptyAIntersection() {
        List<Integer> a = null;
        Integer[] sourceArray = { -3, 0, 5};
        List<Integer> b = Arrays.asList(sourceArray);

        List<Integer> o = ListIntersectionUnion.getIntersection(a, b);
        assertEquals(0, o.size());
    }

    @Test
    public void testEmptyBIntersection() {
        Integer[] sourceArray = { -3, 0, 5};
        List<Integer> a = Arrays.asList(sourceArray);
        ArrayList<Integer> b = null;

        List<Integer> o = ListIntersectionUnion.getIntersection(a, b);
        assertEquals(0, o.size());
    }

    @Test
    public void testEmptyBUnion() {
        Integer[] sourceArray = { -3,  5};
        List<Integer> a = Arrays.asList(sourceArray);
        ArrayList<Integer> b = null;

        List<Integer> o = ListIntersectionUnion.getUnion(a, b);
        assertTrue(-3 == o.get(0));
        assertTrue(5 == o.get(1));
    }

    @Test
    public void testIntersectionUnionCaseOne() {
        Integer[] sourceArray = { -7, -3, 0, 1, 5, 10, 17};
        List<Integer> a = Arrays.asList(sourceArray);

        Integer[] sourceArray1 = { -15, -10, -3, 1, 2, 10};
        List<Integer> b = Arrays.asList(sourceArray1);

        List<Integer> io = ListIntersectionUnion.getIntersection(a, b);
        assertTrue(-3 == io.get(0));
        assertTrue(1 == io.get(1));
        assertTrue(10 == io.get(2));

        List<Integer> uo = ListIntersectionUnion.getUnion(a, b);
        assertTrue(-15 == uo.get(0));
        assertTrue(-10 == uo.get(1));
        assertTrue(-7 == uo.get(2));
        assertTrue(-3 == uo.get(3));
        assertTrue(0 == uo.get(4));
        assertTrue(1 == uo.get(5));
        assertTrue(2 == uo.get(6));
        assertTrue(5 == uo.get(7));
        assertTrue(10 == uo.get(8));
        assertTrue(17 == uo.get(9));
    }
}
