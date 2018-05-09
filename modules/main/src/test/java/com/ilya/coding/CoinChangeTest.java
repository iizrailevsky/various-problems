package com.ilya.coding;

import org.junit.Test;
import static  org.junit.Assert.*;

public class CoinChangeTest {

    private CoinChange coinChange = new CoinChange();

    @Test
    public void testError() {
        assertEquals(-1, coinChange.coinChange(new int[0], 0));
        assertEquals(-1, coinChange.coinChange(new int[]{1}, -1));
    }

    @Test
    public void testBasic() {
        assertEquals(3, coinChange.coinChange(new int[]{1, 2, 5}, 11));
        assertEquals(-1, coinChange.coinChange(new int[]{2}, 3));
    }

    @Test
    public void testAdvanced() {
        assertEquals(-1, coinChange.coinChange(new int[]{186,419, 83,408}, 6249));
    }
}
