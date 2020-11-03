package com.ilya.coding;

import static org.junit.Assert.*;

import org.junit.Test;

public class BalloonInstancesTest {

    @Test
    public void testCases() {
        assertEquals(1, BalloonInstances.maxNumberOfBalloons("nlaebolko"));
        assertEquals(2, BalloonInstances.maxNumberOfBalloons("loonbalxballpoon"));
        assertEquals(0, BalloonInstances.maxNumberOfBalloons("leetcode"));
    }
}
