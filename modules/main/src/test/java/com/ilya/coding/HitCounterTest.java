package com.ilya.coding;

import org.junit.Test;

import static org.junit.Assert.*;

public class HitCounterTest {

    @Test
    public void testErrors() {
        assertTrue(true);
    }

    @Test
    public void testBasic() throws InterruptedException {
        HitCounter hc = new HitCounter();
        hc.hit();
        Thread.sleep(1000);
        hc.hit();
        Thread.sleep(1000);
        hc.hit();
        assertEquals(3, hc.getHits());
        Thread.sleep(1000);
        Thread.sleep(1000);
        Thread.sleep(1000);
        Thread.sleep(1000);
        Thread.sleep(1000);
        Thread.sleep(1000);
        Thread.sleep(1000);
        hc.hit();
        assertEquals(4, hc.getHits());
        Thread.sleep(1000);
        assertEquals(3, hc.getHits());
    }
}
