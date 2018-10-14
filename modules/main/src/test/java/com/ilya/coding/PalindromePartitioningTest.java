package com.ilya.coding;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.junit.Assert.assertThat;

public class PalindromePartitioningTest {

    @Test
    public void testErrors() {
        List<List<String>> expected = new ArrayList();
        assertEquals(Collections.EMPTY_LIST, PalindromePartitioning.partition(""));
        //assertThat(expected, containsInAnyOrder(PalindromePartitioning.partition("")));
    }

    @Test
    public void testBasic() {
        List<List<String>> expected = new ArrayList();
        expected.add(new ArrayList() {{ add("aa"); add("b"); }});
        expected.add(new ArrayList() {{ add("a"); add("a"); add("b"); }});
        assertThat(PalindromePartitioning.partition("aab"), containsInAnyOrder(expected.toArray()));
    }

    @Test
    public void testBasic1() {
        List<List<String>> expected = new ArrayList();
        expected.add(new ArrayList() {{ add("aa"); add("bb"); }});
        expected.add(new ArrayList() {{ add("aa"); add("b"); add("b"); }});
        expected.add(new ArrayList() {{ add("a"); add("a"); add("bb"); }});
        expected.add(new ArrayList() {{ add("a"); add("a"); add("b"); add("b"); }});
        assertThat(PalindromePartitioning.partition("aabb"), containsInAnyOrder(expected.toArray()));
    }

    @Test
    public void testBasic2() {
        List<List<String>> expected = new ArrayList();
        expected.add(new ArrayList() {{ add("efe"); }});
        expected.add(new ArrayList() {{ add("e"); add("f"); add("e"); }});
        assertThat(PalindromePartitioning.partition("efe"), containsInAnyOrder(expected.toArray()));
    }
}
