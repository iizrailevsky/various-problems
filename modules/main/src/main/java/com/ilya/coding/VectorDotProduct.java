package com.ilya.coding;

import java.util.*;

public class VectorDotProduct {

    public static int getVectorDotProduct(Map<Integer, Integer> v1, Map<Integer, Integer> v2) {
        // error checking
        if (v1 == null || v1.isEmpty() || v2 == null || v2.isEmpty()) {
            return -1;
        }

        int dotProduct = 0;

        for (Map.Entry<Integer, Integer> v1Entry : v1.entrySet()) {
            if (v2.containsKey(v1Entry.getKey())) {
                dotProduct += v1Entry.getValue() * v2.get(v1Entry.getKey());
            }
        }

        return dotProduct;
    }
}
