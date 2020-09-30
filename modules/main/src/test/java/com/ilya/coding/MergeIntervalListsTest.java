package com.ilya.coding;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import java.util.*;

public class MergeIntervalListsTest {

    @Test
    public void testEmpty() {
        assertEquals(0, MergeIntervalLists.mergeInervalLists(null, null).size());
    }

    @Test
    public void testOne() {
        List<Interval> one = Arrays.asList(new Interval[] {new Interval(1, 4), new Interval(5, 10),
                    new Interval(15, 19),
                    new Interval(30, 31)});
        List<Interval> two = Arrays.asList(new Interval[] {new Interval(2, 20), new Interval(27, 29)});
        List<Interval> out = MergeIntervalLists.mergeInervalLists(one, two);

        assertEquals(3, out.size());
        assertTrue(1 == out.get(0).start && 20 == out.get(0).end);
        assertTrue(27 == out.get(1).start && 29 == out.get(1).end);
        assertTrue(30 == out.get(2).start && 31 == out.get(2).end);
    }

    @Test
    public void testTwo() {
        List<Interval> one = Arrays.asList(new Interval[] {new Interval(1, 4), new Interval(5, 10),
                new Interval(15, 25),
                new Interval(27, 29)});
        List<Interval> two = Arrays.asList(new Interval[] {new Interval(2, 20), new Interval(24, 26)});
        List<Interval> out = MergeIntervalLists.mergeInervalLists(one, two);

        assertEquals(2, out.size());
        assertTrue(1 == out.get(0).start && 26 == out.get(0).end);
        assertTrue(27 == out.get(1).start && 29 == out.get(1).end);
    }

    @Test
    public void testThree() {
        List<Interval> one = Arrays.asList(new Interval[] {new Interval(1, 4)});
        List<Interval> two = Arrays.asList(new Interval[] {new Interval(5, 6)});
        List<Interval> out = MergeIntervalLists.mergeInervalLists(one, two);

        assertEquals(2, out.size());
        assertTrue(1 == out.get(0).start && 4 == out.get(0).end);
        assertTrue(5 == out.get(1).start && 6 == out.get(1).end);
    }

    @Test
    public void testFour() {
        List<Interval> one = Arrays.asList(new Interval[] {new Interval(5, 6)});
        List<Interval> two = Arrays.asList(new Interval[] {new Interval(1, 4)});
        List<Interval> out = MergeIntervalLists.mergeInervalLists(one, two);

        assertEquals(2, out.size());
        assertTrue(1 == out.get(0).start && 4 == out.get(0).end);
        assertTrue(5 == out.get(1).start && 6 == out.get(1).end);
    }

    @Test
    public void testFive() {
        List<Interval> one = Arrays.asList(new Interval[] {new Interval(1, 4), new Interval(5, 10),
                new Interval(15, 25),
                new Interval(24, 29)});
        List<Interval> two = Arrays.asList(new Interval[] {new Interval(2, 20), new Interval(24, 26)});
        List<Interval> out = MergeIntervalLists.mergeInervalLists(one, two);

        assertEquals(1, out.size());
        assertTrue(1 == out.get(0).start && 29 == out.get(0).end);
    }
}
