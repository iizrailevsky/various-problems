package com.ilya.coding;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNull;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import java.util.List;

import org.junit.Test;

import java.util.Arrays;

public class RepeatedDnaSequencesTest {
    @Test
    public void testNull() {
        List<String> res = RepeatedDnaSequences.findRepeatedDnaSequences(null);
        assertEquals(0, res.size());
    }

    @Test
    public void testEmpty() {
        List<String> res = RepeatedDnaSequences.findRepeatedDnaSequences("");
        assertEquals(0, res.size());
    }

    @Test
    public void testTooShort() {
        List<String> res = RepeatedDnaSequences.findRepeatedDnaSequences("AAABBB");
        assertEquals(0, res.size());
    }

    @Test
    public void testCaseOne() {
        List<String> res = RepeatedDnaSequences.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
        assertThat(Arrays.asList("AAAAACCCCC", "CCCCCAAAAA") ,
                containsInAnyOrder(res.toArray()));
    }

    @Test
    public void testCaseTwo() {
        List<String> res = RepeatedDnaSequences.findRepeatedDnaSequences("AAAAAAAAAAAA");
        assertThat(Arrays.asList("AAAAAAAAAA") ,
                containsInAnyOrder(res.toArray()));
    }
}
