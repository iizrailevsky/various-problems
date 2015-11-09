package com.ilya.coding;

import static org.junit.Assert.*;

import org.junit.Test;

public class JumpFurtherTest {

    @Test
    public void testErrors() {
        JumpFurther jf = new JumpFurther();
        assertEquals(-1, jf.farthestIterative(-1, 3));
        assertEquals(-1, jf.farthestIterative(1, -3));
    }

    @Test
    public void test() {
        JumpFurther jf = new JumpFurther();
        assertEquals(5, jf.farthestIterative(3, 3));
        assertEquals(-1, jf.farthestIterative(1, 0));
        assertEquals(3, jf.farthestIterative(2, 2));
        assertEquals(2, jf.farthestIterative(2, 1));
        assertEquals(54, jf.farthestIterative(10, 10));
        assertEquals(55, jf.farthestIterative(10, 9));
        assertEquals(1, jf.farthestIterative(1, 757065));
        assertEquals(862641, jf.farthestIterative(1313, 5858));
    }

}
