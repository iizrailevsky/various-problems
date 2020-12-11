package com.ilya.coding;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class ShortEncodingOfWordsTest {

    @Test (expected = IllegalArgumentException.class)
    public void testErrors() {
        ShortEncodingOfWords.minimumLengthEncoding(null);
    }

    
    @Test
    public void testBasic() {
       assertEquals(10, ShortEncodingOfWords.minimumLengthEncoding(new String[] {"time", "me", "bell"}));
        assertEquals(13, ShortEncodingOfWords.minimumLengthEncoding(new String[] {"time", "me", "subtime", "bell"}));
        assertEquals(12, ShortEncodingOfWords.minimumLengthEncoding(new String[] {"time", "atime", "btime"}));
    }

}
