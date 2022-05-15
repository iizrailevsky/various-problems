package com.ilya.coding;

import org.junit.Test;
import static org.junit.Assert.*;

public class CountVowelStringsTest {

    @Test
    public void testErrors() {
        assertEquals(0, CountVowelStrings.countVowelStrings(-1));
        assertEquals(0, CountVowelStrings.countVowelStrings(0));
    }

    @Test
    public void testBasic() {
        assertEquals(5, CountVowelStrings.countVowelStrings(1));
        assertEquals(15, CountVowelStrings.countVowelStrings(2));
        assertEquals(66045, CountVowelStrings.countVowelStrings(33));
    }
}
