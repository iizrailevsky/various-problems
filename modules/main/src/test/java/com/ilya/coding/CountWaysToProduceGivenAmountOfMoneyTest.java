package com.ilya.coding;

import org.junit.Test;

import static org.junit.Assert.*;

public class CountWaysToProduceGivenAmountOfMoneyTest {

    @Test
    public void testBasic() {
        assertEquals(2, CountWaysToProduceGivenAmountOfMoney.countWaysToProduceGivenAmountOfMoney(5));
        assertEquals(4, CountWaysToProduceGivenAmountOfMoney.countWaysToProduceGivenAmountOfMoney(10));
    }
}
