package com.ilya.coding;

import org.junit.Test;

import java.util.*;

import static  org.junit.Assert.*;

public class CommonListElementsTest {
    @Test
    public void testEmpty() {
        List<Integer> expected = new ArrayList<>();
        assertEquals(expected, CommonListElements.getCommonElements(null));
    }

    @Test
    public void testCase() {
        List<List<Integer>> in = new ArrayList<>();
        in.add(Arrays.asList(1, 3, 4, 5, 7, 8, 10, 14));
        in.add(Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9, 10, 11));
        in.add(Arrays.asList(2, 3, 5, 7, 9, 11));

        List<Integer> expected = Arrays.asList(3, 5, 7);

        System.out.println(CommonListElements.getCommonElements(in));

    }
}
