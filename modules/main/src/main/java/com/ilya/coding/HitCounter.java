package com.ilya.coding;

import java.util.*;

public class HitCounter {

    private static final long LIMIT = 10000L;
    private Set<Long> hits;

    public HitCounter() {
        hits = Collections.newSetFromMap(new LinkedHashMap<Long, Boolean>() {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Long, Boolean> eldest) {
                return eldest.getKey() < System.currentTimeMillis() - LIMIT;
            }
        });
    }

    public void hit() {
        System.out.println(System.currentTimeMillis());
        hits.add(System.currentTimeMillis());
    }

    public int getHits() {
        int count = 0;
        for (long hit : hits) {
            if (hit >= System.currentTimeMillis() - LIMIT) {
                count++;
            }
        }
        System.out.println("size: " + hits.size());
        System.out.println("count: " + count);
        return count;
    }
}
