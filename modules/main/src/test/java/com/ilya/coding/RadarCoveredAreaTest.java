package com.ilya.coding;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class RadarCoveredAreaTest {

    @Test
    public void testErrors() {
        assertEquals(-1, RadarCoveredArea.getCoveredArea(0, new ArrayList<>()));
    }

    // [ [5, 10], [3, 25], [46, 99], [39, 40], [45, 50] ]
    @Test
    public void testBasic() {
        List<List<Integer>> radars = new ArrayList<>();
        List<Integer> r1 = new ArrayList<>();
        r1.add(5);
        r1.add(10);
        radars.add(r1);
        List<Integer> r2 = new ArrayList<>();
        r2.add(3);
        r2.add(25);
        radars.add(r2);
        List<Integer> r3 = new ArrayList<>();
        r3.add(46);
        r3.add(99);
        radars.add(r3);
        List<Integer> r4 = new ArrayList<>();
        r4.add(39);
        r4.add(40);
        radars.add(r4);
        List<Integer> r5 = new ArrayList<>();
        r5.add(45);
        r5.add(50);
        radars.add(r5);
        assertEquals(77, RadarCoveredArea.getCoveredArea(100, radars));
    }
}
