package com.ilya.coding;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import java.util.*;

public class MaximumCompletedTasksTest {
    @Test
    public void testErrors() {
        assertEquals(0, MaximumCompletedTasks.maximumCompletedTasks(0, 0 , null));
        assertEquals(0, MaximumCompletedTasks.maximumCompletedTasks(0, 1, null));
        assertEquals(0, MaximumCompletedTasks.maximumCompletedTasks(0, 0 , new ArrayList<>()));
    }

    @Test
    public void testBasic() {
        List<Integer> list = new ArrayList<>();
        list.add(24);
        list.add(23);
        list.add(22);
        list.add(10);
        list.add(20);
        assertEquals(3, MaximumCompletedTasks.maximumCompletedTasks(5, 65 , list));
    }
}
