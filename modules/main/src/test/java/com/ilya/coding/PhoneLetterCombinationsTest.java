package com.ilya.coding;

import static org.junit.Assert.*;

import org.junit.Test;

public class PhoneLetterCombinationsTest {

    @Test (expected = IllegalArgumentException.class)
    public void testErrors() {
        assertNull(PhoneLetterCombinations.letterCombinations(null));
        assertEquals(0, PhoneLetterCombinations.letterCombinations("").size());
        PhoneLetterCombinations.letterCombinations("10");
    }

    @Test
    public void testBasic() {
        assertEquals(9, PhoneLetterCombinations.letterCombinations("23").size());
        assertEquals(27, PhoneLetterCombinations.letterCombinations("234").size());
    }
}
