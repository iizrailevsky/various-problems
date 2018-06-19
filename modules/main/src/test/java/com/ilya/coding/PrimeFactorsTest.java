package com.ilya.coding;

import java.util.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class PrimeFactorsTest {

    @Test
    public void testErrors() {
        assertNull(PrimeFactors.findAllPrimeFactors(0));
    }

    @Test
    public void testBasic() {
        List<Long> result = PrimeFactors.findAllPrimeFactors(100);
        result.forEach(System.out::println);
        result = PrimeFactors.findAllPrimeFactors(17);
        result.forEach(System.out::println);
    }

    @Test
    public void testCountNumbersFactorsErrors() {
        assertEquals(0, PrimeFactors.countNumbersFactors(0));
    }

    @Test
    public void testCountNumbersFactorsBasic() {
        assertEquals(6, PrimeFactors.countNumbersFactors(12));
        assertEquals(9, PrimeFactors.countNumbersFactors(100));
    }
}
