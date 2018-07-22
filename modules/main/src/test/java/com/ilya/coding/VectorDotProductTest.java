package com.ilya.coding;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.*;

public class VectorDotProductTest {

    @Test
    public void testErrors() {
        assertEquals(-1, VectorDotProduct.getVectorDotProduct(null, Collections.EMPTY_MAP));
    }

    @Test
    public void testBasic() {
        Map<Integer, Integer> v1 = new HashMap();
        v1.put(0, 5);
        v1.put(3, 3);
        v1.put(4, 17);
        v1.put(6, 8);

        Map<Integer, Integer> v2 = new HashMap();
        v2.put(1, 13);
        v2.put(3, 5);
        v2.put(4, 5);
        v2.put(5, 7);

        assertEquals(100, VectorDotProduct.getVectorDotProduct(v1, v2));
    }
}
